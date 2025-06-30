package it.apuliadigital.esame_EnricoDeVittorip.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "openMeteoClient", url = "https://api.open-meteo.com/v1")
public interface OpenMeteoClient {

    @GetMapping("/forecast")
    Map<String, Object> getWeather(
        @RequestParam("latitude") double latitude,
        @RequestParam("longitude") double longitude,
        @RequestParam("current") String current
    );
}
