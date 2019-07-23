package com.practice.weatherappusingmvvmdatabinding.di;

import com.practice.weatherappusingmvvmdatabinding.utils.RetrofitUtils;
import com.practice.weatherappusingmvvmdatabinding.network.WeatherService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class AppModule {

    @Singleton
    @Provides
    static Retrofit provideRetrofitInstance() {
        return new RetrofitUtils().getRetrofitInstance();
    }

    @Provides
    static WeatherService provideWeatherService(Retrofit retrofit) {
        return retrofit.create(WeatherService.class);
    }


}
