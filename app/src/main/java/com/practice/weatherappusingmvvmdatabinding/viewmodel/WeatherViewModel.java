package com.practice.weatherappusingmvvmdatabinding.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import com.practice.weatherappusingmvvmdatabinding.adapters.WeatherListAdapter;
import com.practice.weatherappusingmvvmdatabinding.models.WeatherInfo;
import com.practice.weatherappusingmvvmdatabinding.network.WeatherService;
import com.practice.weatherappusingmvvmdatabinding.network.WeatherServiceManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class WeatherViewModel implements LifecycleObserver {

    public WeatherListAdapter adapter;
    private List<WeatherItemViewModel> weatherInfoList;
    private List<String> citiesToBePreLoaded;

    WeatherServiceManager weatherServiceManager;

    @Inject
    public WeatherViewModel(WeatherServiceManager weatherServiceManager) {
        this.weatherServiceManager = weatherServiceManager;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        setAdapter();
        generateListOfCitiesToBePreLoaded();
        if (citiesToBePreLoaded != null) {
            fetchDataFromServer(citiesToBePreLoaded);
        }
    }

    private void setAdapter() {
        weatherInfoList = new ArrayList<>();
        adapter = new WeatherListAdapter(weatherInfoList);
    }

    private void generateListOfCitiesToBePreLoaded() {
        citiesToBePreLoaded = new ArrayList<>();
        citiesToBePreLoaded.add("chennai");
        citiesToBePreLoaded.add("mumbai");
        citiesToBePreLoaded.add("bangalore");
        citiesToBePreLoaded.add("delhi");
        citiesToBePreLoaded.add("kochi");
        citiesToBePreLoaded.add("madurai");
        citiesToBePreLoaded.add("coimbatore");
    }

    private void fetchDataFromServer(final List<String> listOfCities) {
        for (String cityName : listOfCities) {

            weatherServiceManager.getWeatherInfo(cityName, "metric").subscribe(this::populateView, this::showErrorMessage);

        }
    }


    public void populateView(WeatherInfo weatherInfo) {
        if (weatherInfo != null) {
            WeatherItemViewModel weatherItemViewModel = new WeatherItemViewModel();
            weatherItemViewModel.setCityName(weatherInfo.getName());
            weatherItemViewModel.setWeatherDescription(weatherInfo.getWeather().getDescription());
            weatherItemViewModel.setImageUrl(weatherInfo.getWeather().getIcon());
            weatherItemViewModel.setAverageTemperature(weatherInfo.getWeatherData().getTemperature());
            weatherItemViewModel.setMaximumTemperature(weatherInfo.getWeatherData().getMaximumTemperature());
            weatherItemViewModel.setMinimumTemperature(weatherInfo.getWeatherData().getMinimumTemparature());
            weatherInfoList.add(weatherItemViewModel);
            adapter.notifyDataSetChanged();
        }
    }

    private void showErrorMessage(Throwable throwable) {
        System.out.println(throwable.getLocalizedMessage());
    }
}
