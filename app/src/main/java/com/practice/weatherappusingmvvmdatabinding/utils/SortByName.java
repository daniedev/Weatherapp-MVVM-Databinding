package com.practice.weatherappusingmvvmdatabinding.utils;

import com.practice.weatherappusingmvvmdatabinding.models.WeatherInfo;
import com.practice.weatherappusingmvvmdatabinding.viewmodel.WeatherItemViewModel;

import java.util.Comparator;

public class SortByName implements Comparator<WeatherItemViewModel> {

    @Override
    public int compare(WeatherItemViewModel o1, WeatherItemViewModel o2) {
        return o1.getCityName().compareTo(o2.getCityName());
    }
}
