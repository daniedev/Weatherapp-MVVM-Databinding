package com.practice.weatherappusingmvvmdatabinding;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.practice.weatherappusingmvvmdatabinding.databinding.ActivityWeatherBinding;
import com.practice.weatherappusingmvvmdatabinding.viewmodel.WeatherViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class WeatherActivity extends AppCompatActivity implements LifecycleOwner {


    ActivityWeatherBinding binding;

    @Inject
    WeatherViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_weather);
        binding.setViewModel(viewModel);
        this.getLifecycle().addObserver(viewModel);
    }
}
