package it.apuliadigital.esame_EnricoDeVittorip.service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.apuliadigital.esame_EnricoDeVittorip.client.OpenMeteoClient;
import it.apuliadigital.esame_EnricoDeVittorip.client.RestCountriesClient;
import it.apuliadigital.esame_EnricoDeVittorip.entity.CountryWeather;
import it.apuliadigital.esame_EnricoDeVittorip.model.CountryWeatherDTO;
import it.apuliadigital.esame_EnricoDeVittorip.model.WeatherDTO;
import it.apuliadigital.esame_EnricoDeVittorip.repository.CountryWeatherRepository;

@Service
public class CountryWeatherServiceImpl implements ICountryWeatherService {

    private final RestCountriesClient restCountriesClient;
    private final OpenMeteoClient openMeteoClient;
    private final CountryWeatherRepository repository;

    public CountryWeatherServiceImpl(RestCountriesClient restCountriesClient, OpenMeteoClient openMeteoClient, CountryWeatherRepository repository) {
        this.restCountriesClient = restCountriesClient;
        this.openMeteoClient = openMeteoClient;
        this.repository = repository;
    }

    public CountryWeatherDTO getCountryWeather(String country) {

        // Recuperare dati 
        List<Map<String, Object>> countryDataList = restCountriesClient.getCountryData(country);
        if (countryDataList == null || countryDataList.isEmpty()) {
            throw new RuntimeException("Paese non trovato: " + country);
        }

        Map<String, Object> data = countryDataList.get(0);
        String capital = ((List<String>) data.get("capital")).get(0);
        long population = ((Number) data.get("population")).longValue();
        String currency = ((Map<String, Map<String, Object>>) data.get("currencies")).keySet().iterator().next();
        String flagPng = (String) ((Map<String, Object>) data.get("flags")).get("png");

        List<Double> latlng = (List<Double>) ((Map<String, Object>) data.get("capitalInfo")).get("latlng");
        double lat = latlng.get(0);
        double lon = latlng.get(1);

        // Recuperae meteo
        Map<String, Object> weatherData = openMeteoClient.getWeather(lat, lon, "temperature_2m,weather_code");
        Map<String, Object> current = (Map<String, Object>) weatherData.get("current");
        double temperature = ((Number) current.get("temperature_2m")).doubleValue();
        int weatherCode = ((Number) current.get("weather_code")).intValue();
        ZonedDateTime retrievedAt = ZonedDateTime.parse(current.get("time") + "Z");

        Optional<CountryWeather> existing = repository.findById(country);

        CountryWeather entity = existing.orElse(new CountryWeather());
        entity.setCountry(country);
        entity.setCapital(capital);
        entity.setPopulation(population);
        entity.setCurrency(currency);
        entity.setFlagPng(flagPng);
        entity.setTemperature(temperature);
        entity.setWeatherCode(weatherCode);
        entity.setRetrievedAt(retrievedAt);

        repository.save(entity);

        // Costruzione DTO
        WeatherDTO weatherDTO = new WeatherDTO();
        weatherDTO.setTemperature(temperature);
        weatherDTO.setCode(weatherCode);
        weatherDTO.setRetrievedAt(retrievedAt);

        CountryWeatherDTO dto = new CountryWeatherDTO();
        dto.setCountry(country);
        dto.setCapital(capital);
        dto.setPopulation(population);
        dto.setCurrency(currency);
        dto.setFlagPng(flagPng);
        dto.setWeather(weatherDTO);

        return dto;
    }

    @Override
    public CountryWeatherDTO updateCountryWeather(String country, Boolean visited, String notes, Integer rating) {
        var existingOpt = repository.findById(country);
        if (existingOpt.isEmpty()) {
            throw new RuntimeException("Country not found: " + country);
        }

        var entity = existingOpt.get();
        if (visited != null) entity.setVisited(visited);
        if (notes != null) entity.setNotes(notes);
        if (rating != null) entity.setRating(rating);

        repository.save(entity);

        // Ricostruisci DTO
        var weatherDTO = new WeatherDTO();
        weatherDTO.setTemperature(entity.getTemperature());
        weatherDTO.setCode(entity.getWeatherCode());
        weatherDTO.setRetrievedAt(entity.getRetrievedAt());

        var dto = new CountryWeatherDTO();
        dto.setCountry(entity.getCountry());
        dto.setCapital(entity.getCapital());
        dto.setPopulation(entity.getPopulation());
        dto.setCurrency(entity.getCurrency());
        dto.setFlagPng(entity.getFlagPng());
        dto.setWeather(weatherDTO);

        return dto;
    }
}
