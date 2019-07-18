package com.practice.weatherappusingmvvmdatabinding.di;

import com.practice.weatherappusingmvvmdatabinding.WeatherActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract WeatherActivity provideWeatherActivity();
}
