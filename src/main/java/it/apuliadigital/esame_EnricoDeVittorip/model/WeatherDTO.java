package it.apuliadigital.esame_EnricoDeVittorip.model;

import java.time.ZonedDateTime;

public class WeatherDTO {
    

    private double temperature;
    private int code;
    private ZonedDateTime retrievedAt;


    // Costruttore di default
    public WeatherDTO() {
    }

    // Costruttore con parametri
    public WeatherDTO(double temperature, int code, ZonedDateTime retrievedAt) {
        this.temperature = temperature;
        this.code = code;
        this.retrievedAt = retrievedAt;
    }

    // Getters e Setters
    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public ZonedDateTime getRetrievedAt() {
        return retrievedAt;
    }
    public void setRetrievedAt(ZonedDateTime retrievedAt) {
        this.retrievedAt = retrievedAt;
    }


    // Override ToString
    @Override
    public String toString() {
        return "WeatherDTO [temperature=" + temperature + ", code=" + code + ", retrievedAt=" + retrievedAt
                + ", getTemperature()=" + getTemperature() + ", getCode()=" + getCode() + ", getRetrievedAt()="
                + getRetrievedAt() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }


    // Override hashCode e equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(temperature);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + code;
        result = prime * result + ((retrievedAt == null) ? 0 : retrievedAt.hashCode());
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
        WeatherDTO other = (WeatherDTO) obj;
        if (Double.doubleToLongBits(temperature) != Double.doubleToLongBits(other.temperature))
            return false;
        if (code != other.code)
            return false;
        if (retrievedAt == null) {
            if (other.retrievedAt != null)
                return false;
        } else if (!retrievedAt.equals(other.retrievedAt))
            return false;
        return true;
    }

    

    
}
