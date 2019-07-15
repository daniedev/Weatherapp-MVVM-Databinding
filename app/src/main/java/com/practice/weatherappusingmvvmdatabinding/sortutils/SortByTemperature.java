package com.practice.weatherappusingmvvmdatabinding.sortutils;

import com.practice.weatherappusingmvvmdatabinding.models.WeatherInfo;

import java.util.Comparator;

public class SortByTemperature implements Comparator<WeatherInfo> {


    @Override
    public int compare(WeatherInfo o1, WeatherInfo o2) {
        return (int)o1.getMain().temperature - (int)o2.getMain().temperature;
    }
}
