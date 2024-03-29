package com.practice.weatherappusingmvvmdatabinding.di;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {AndroidSupportInjectionModule.class, ActivityBuildersModule.class, AppModule.class}
)
public interface AppComponent extends AndroidInjector<WeatherApplication> {


}
