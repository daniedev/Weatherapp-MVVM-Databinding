package com.practice.weatherappusingmvvmdatabinding;

import android.arch.lifecycle.LifecycleOwner;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.practice.weatherappusingmvvmdatabinding.databinding.ActivityWeatherBinding;
import com.practice.weatherappusingmvvmdatabinding.viewmodel.WeatherViewModel;

public class WeatherActivity extends AppCompatActivity implements LifecycleOwner {
    ActivityWeatherBinding binding;
    WeatherViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_weather);
        viewModel = new WeatherViewModel();
        binding.setViewModel(viewModel);
        this.getLifecycle().addObserver(viewModel);
    }
}
