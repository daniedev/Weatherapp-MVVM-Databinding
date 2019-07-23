package com.practice.weatherappusingmvvmdatabinding.network;

import com.practice.weatherappusingmvvmdatabinding.models.WeatherInfo;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WeatherServiceManager  {
    WeatherService weatherService;

    @Inject
    public WeatherServiceManager(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public Observable<WeatherInfo> getWeatherInfo(String place, String units){
        return weatherService.getWeatherInfo(place,units).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }


}
