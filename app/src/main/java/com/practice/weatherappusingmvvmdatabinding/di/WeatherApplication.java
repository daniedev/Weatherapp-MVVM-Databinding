package com.practice.weatherappusingmvvmdatabinding.di;

import android.app.Activity;
import android.app.Application;

import com.practice.weatherappusingmvvmdatabinding.di.AppComponent;
import com.practice.weatherappusingmvvmdatabinding.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class WeatherApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        AppComponent daggerAppComponent = DaggerAppComponent.create();
        daggerAppComponent.inject(this);
    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
