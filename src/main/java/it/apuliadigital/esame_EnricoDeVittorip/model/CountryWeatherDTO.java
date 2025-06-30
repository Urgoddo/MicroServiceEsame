package it.apuliadigital.esame_EnricoDeVittorip.model;

public class CountryWeatherDTO {


    private String country;
    private String capital;
    private long population;
    private String currency;
    private String flagPng;
    private WeatherDTO weather;

    //Costruttore di default
    public CountryWeatherDTO(){

    }

    //Costruttore con parametri
    public CountryWeatherDTO(String country, String capital, long population, String currency, String flagPng, WeatherDTO weather) {
        this.country = country;
        this.capital = capital;
        this.population = population;
        this.currency = currency;
        this.flagPng = flagPng;
        this.weather = weather;
    }


    // Getters e Setters
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
    public WeatherDTO getWeather() {
        return weather;
    }
    public void setWeather(WeatherDTO weather) {
        this.weather = weather;
    }

    // Override ToString
    @Override
    public String toString() {
        return "CountryWeatherDTO [country=" + country + ", capital=" + capital + ", population=" + population
                + ", currency=" + currency + ", flagPng=" + flagPng + ", weather=" + weather + ", getCountry()="
                + getCountry() + ", getCapital()=" + getCapital() + ", getPopulation()=" + getPopulation()
                + ", getCurrency()=" + getCurrency() + ", getFlagPng()=" + getFlagPng() + ", getWeather()="
                + getWeather() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }

    // Override hashCode e equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((capital == null) ? 0 : capital.hashCode());
        result = prime * result + (int) (population ^ (population >>> 32));
        result = prime * result + ((currency == null) ? 0 : currency.hashCode());
        result = prime * result + ((flagPng == null) ? 0 : flagPng.hashCode());
        result = prime * result + ((weather == null) ? 0 : weather.hashCode());
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
        CountryWeatherDTO other = (CountryWeatherDTO) obj;
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
        if (weather == null) {
            if (other.weather != null)
                return false;
        } else if (!weather.equals(other.weather))
            return false;
        return true;
    }
    
}
