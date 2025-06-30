package it.apuliadigital.esame_EnricoDeVittorip.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@FeignClient(name = "restCountriesClient", url = "https://restcountries.com/v3.1")
public interface RestCountriesClient {

    @GetMapping("/name/{country}?fullText=true")
    List<Map<String, Object>> getCountryData(@PathVariable("country") String country);
}
