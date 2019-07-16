package com.practice.weatherappusingmvvmdatabinding.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModel;

import com.practice.weatherappusingmvvmdatabinding.models.WeatherInfo;
import com.practice.weatherappusingmvvmdatabinding.network.RetrofitInstance;
import com.practice.weatherappusingmvvmdatabinding.network.WeatherService;
import com.practice.weatherappusingmvvmdatabinding.utils.SortByName;
import com.practice.weatherappusingmvvmdatabinding.adapters.WeatherListAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel extends ViewModel implements LifecycleObserver {

    public WeatherListAdapter adapter;
    private List<WeatherItemViewModel> weatherInfoList;
    private WeatherService getData;
    private List<String> citiesToBePreLoaded;


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        setAdapter();
        generateListOfCitiesToBePreLoaded();
        establishNetworkLayerandPreLoadData();
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

    private void establishNetworkLayerandPreLoadData() {
        getData = new RetrofitInstance().getRetrofitInstance().create(WeatherService.class);
        if (citiesToBePreLoaded != null) {
            fetchDataFromServer(citiesToBePreLoaded);
        }

    }

    private void fetchDataFromServer(final List<String> listOfCities) {
        for (String cityName : listOfCities) {
            Call<WeatherInfo> networkCall = getData.getWeatherInfo(cityName, "metric");
            networkCall.enqueue(new Callback<WeatherInfo>() {
                @Override
                public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                    if (response.body() != null) {
                        WeatherInfo dataReceived = response.body();
                        WeatherItemViewModel weatherItemViewModel = new WeatherItemViewModel();
                        weatherItemViewModel.setCityName(dataReceived.getName());
                        weatherItemViewModel.setWeatherDescription(dataReceived.getWeather().getDescription());
                        weatherItemViewModel.setImageUrl(dataReceived.getWeather().getIcon());
                        weatherItemViewModel.setAverageTemperature(dataReceived.getWeatherData().getTemperature());
                        weatherItemViewModel.setMaximumTemperature(dataReceived.getWeatherData().getMaximumTemperature());
                        weatherItemViewModel.setMinimumTemperature(dataReceived.getWeatherData().getMinimumTemparature());
                        weatherInfoList.add(weatherItemViewModel);
                    }

                    if (citiesToBePreLoaded.size() == weatherInfoList.size()) {
                        Collections.sort(weatherInfoList, new SortByName());
                        adapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Call<WeatherInfo> call, Throwable t) {
                }
            });

        }
    }

}
