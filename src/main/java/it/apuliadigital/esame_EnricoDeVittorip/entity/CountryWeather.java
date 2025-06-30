package it.apuliadigital.esame_EnricoDeVittorip.entity;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
public class CountryWeather {

    @Id
    private String country; 

    private String capital;
    private long population;
    private String currency;
    private String flagPng;

    private double temperature;
    private int weatherCode;
    private ZonedDateTime retrievedAt;

    private Boolean visited;
    private String notes;
    private Integer rating;

    // Default constructor
    public CountryWeather() {
    }

    // Parameterized constructor
    public CountryWeather(String country, String capital, long population, String currency, String flagPng, double temperature, int weatherCode, ZonedDateTime retrievedAt, Boolean visited, String notes, Integer rating) {

        this.country = country;
        this.capital = capital;
        this.population = population;
        this.currency = currency;
        this.flagPng = flagPng;
        this.temperature = temperature;
        this.weatherCode = weatherCode;
        this.retrievedAt = retrievedAt;
        this.visited = visited;
        this.notes = notes;
        this.rating = rating;
    }


    // Getters and Setters
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }
    public long getPopulation() {
        return population;
    }
    public void setPopulation(long population) {
        this.population = population;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public String getFlagPng() {
        return flagPng;
    }
    public void setFlagPng(String flagPng) {
        this.flagPng = flagPng;
    }
    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public int getWeatherCode() {
        return weatherCode;
    }
    public void setWeatherCode(int weatherCode) {
        this.weatherCode = weatherCode;
    }
    public ZonedDateTime getRetrievedAt() {
        return retrievedAt;
    }
    public void setRetrievedAt(ZonedDateTime retrievedAt) {
        this.retrievedAt = retrievedAt;
    }
    public Boolean getVisited() {
        return visited;
    }
    public void setVisited(Boolean visited) {
        this.visited = visited;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    // Override ToString
    @Override
    public String toString() {
        return "CountryWeather [country=" + country + ", capital=" + capital + ", population=" + population
                + ", currency=" + currency + ", flagPng=" + flagPng + ", temperature=" + temperature + ", weatherCode="
                + weatherCode + ", retrievedAt=" + retrievedAt + ", visited=" + visited + ", notes=" + notes
                + ", rating=" + rating + ", getCountry()=" + getCountry() + ", getCapital()=" + getCapital()
                + ", getPopulation()=" + getPopulation() + ", getCurrency()=" + getCurrency() + ", getFlagPng()="
                + getFlagPng() + ", getTemperature()=" + getTemperature() + ", getWeatherCode()=" + getWeatherCode()
                + ", getRetrievedAt()=" + getRetrievedAt() + ", getClass()=" + getClass() + ", getVisited()="
                + getVisited() + ", getNotes()=" + getNotes() + ", getRating()=" + getRating() + ", hashCode()="
                + hashCode() + ", toString()=" + super.toString() + "]";
    }

    // Override hashCode and equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((capital == null) ? 0 : capital.hashCode());
        result = prime * result + (int) (population ^ (population >>> 32));
        result = prime * result + ((currency == null) ? 0 : currency.hashCode());
        result = prime * result + ((flagPng == null) ? 0 : flagPng.hashCode());
        long temp;
        temp = Double.doubleToLongBits(temperature);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + weatherCode;
        result = prime * result + ((retrievedAt == null) ? 0 : retrievedAt.hashCode());
        result = prime * result + ((visited == null) ? 0 : visited.hashCode());
        result = prime * result + ((notes == null) ? 0 : notes.hashCode());
        result = prime * result + ((rating == null) ? 0 : rating.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CountryWeather other = (CountryWeather) obj;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (capital == null) {
            if (other.capital != null)
                return false;
        } else if (!capital.equals(other.capital))
            return false;
        if (population != other.population)
            return false;
        if (currency == null) {
            if (other.currency != null)
                return false;
        } else if (!currency.equals(other.currency))
            return false;
        if (flagPng == null) {
            if (other.flagPng != null)
                return false;
        } else if (!flagPng.equals(other.flagPng))
            return false;
        if (Double.doubleToLongBits(temperature) != Double.doubleToLongBits(other.temperature))
            return false;
        if (weatherCode != other.weatherCode)
            return false;
        if (retrievedAt == null) {
            if (other.retrievedAt != null)
                return false;
        } else if (!retrievedAt.equals(other.retrievedAt))
            return false;
        if (visited == null) {
            if (other.visited != null)
                return false;
        } else if (!visited.equals(other.visited))
            return false;
        if (notes == null) {
            if (other.notes != null)
                return false;
        } else if (!notes.equals(other.notes))
            return false;
        if (rating == null) {
            if (other.rating != null)
                return false;
        } else if (!rating.equals(other.rating))
            return false;
        return true;
    }
 
}
