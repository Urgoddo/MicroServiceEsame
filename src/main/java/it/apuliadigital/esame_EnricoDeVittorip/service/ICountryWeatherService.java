package it.apuliadigital.esame_EnricoDeVittorip.service;

import it.apuliadigital.esame_EnricoDeVittorip.model.CountryWeatherDTO;

public interface ICountryWeatherService {
    
    CountryWeatherDTO getCountryWeather(String country);

    CountryWeatherDTO updateCountryWeather(String country, Boolean visited, String notes, Integer rating);
}