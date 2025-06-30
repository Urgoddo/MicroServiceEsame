package it.apuliadigital.esame_EnricoDeVittorip.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import it.apuliadigital.esame_EnricoDeVittorip.model.CountryWeatherDTO;
import it.apuliadigital.esame_EnricoDeVittorip.service.CountryWeatherServiceImpl;

@RestController
@RequestMapping("/country-weather")
public class CountryWeatherController {

    private final CountryWeatherServiceImpl service;

    public CountryWeatherController(CountryWeatherServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{country}")
    @Operation(
        summary = "Get weather and info for country",
        description = "Recupera i dati del paese e il meteo attuale.",
        responses = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Country not found"),
            @ApiResponse(responseCode = "502", description = "External API failure")
        }
    )
    public ResponseEntity<CountryWeatherDTO> getCountryWeather(@PathVariable String country) {
        CountryWeatherDTO dto = service.getCountryWeather(country);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{country}")
    public ResponseEntity<CountryWeatherDTO> updateCountryWeather(@PathVariable String country, @RequestBody Map<String, Object> updates) {

    Boolean visited = (Boolean) updates.get("visited");
    String notes = (String) updates.get("notes");
    Integer rating = updates.get("rating") != null ? (Integer) updates.get("rating") : null;

    CountryWeatherDTO dto = service.updateCountryWeather(country, visited, notes, rating);
    return ResponseEntity.ok(dto);
}
}
