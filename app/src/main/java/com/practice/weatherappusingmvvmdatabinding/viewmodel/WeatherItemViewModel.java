package com.practice.weatherappusingmvvmdatabinding.viewmodel;

public class WeatherItemViewModel  {

    private String cityName;
    private String weatherDescription;
    private String imageUrl;
    private int averageTemperature;
    private int minimumTemperature;
    private int maximumTemperature;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getAverageTemperature() {
        return  averageTemperature;
    }

    public void setAverageTemperature(Integer averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public int getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(Integer minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

    public int getMaximumTemperature() {
        return maximumTemperature;
    }

    public void setMaximumTemperature(Integer maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }
}
