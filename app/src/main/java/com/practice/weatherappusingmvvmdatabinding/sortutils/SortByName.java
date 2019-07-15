package com.practice.weatherappusingmvvmdatabinding.sortutils;

import com.practice.weatherappusingmvvmdatabinding.models.WeatherInfo;

import java.util.Comparator;

public class SortByName implements Comparator<WeatherInfo> {


    @Override
    public int compare(WeatherInfo o1, WeatherInfo o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
