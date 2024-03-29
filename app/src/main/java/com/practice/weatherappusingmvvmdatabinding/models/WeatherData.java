package com.practice.weatherappusingmvvmdatabinding.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class WeatherData implements Serializable {

    String degreeSymbol = "°";

    @SerializedName("temp")
    public double temperature;

    @SerializedName("pressure")
    private int pressure;

    @SerializedName("humidity")
    private int humidity;

    @SerializedName("temp_min")
    private double minimumTemparature;

    @SerializedName("temp_max")
    private double maximumTemperature;

    public int getTemperature() {
        return (int)temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getMinimumTemparature() {
        return (int)minimumTemparature;
    }

    public void setMinimumTemparature(double minimumTemparature) {
        this.minimumTemparature = minimumTemparature;
    }


    public int getMaximumTemperature() {
        return (int)maximumTemperature;
    }

    public void setMaximumTemperature(double maximumTemperature) {
        this.maximumTemperature = maximumTemperature;
    }
}
