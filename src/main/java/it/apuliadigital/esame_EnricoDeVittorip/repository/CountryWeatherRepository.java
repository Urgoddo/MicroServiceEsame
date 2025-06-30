package it.apuliadigital.esame_EnricoDeVittorip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.apuliadigital.esame_EnricoDeVittorip.entity.CountryWeather;

public interface CountryWeatherRepository extends JpaRepository<CountryWeather, String> {
}
