package com.practice.weatherappusingmvvmdatabinding.view.weatherlistadapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.practice.weatherappusingmvvmdatabinding.models.WeatherInfo;
import com.practice.weatherappusingmvvmdatabinding.databinding.ItemLayoutWeatherBinding;

class WeatherListViewHolder extends RecyclerView.ViewHolder {
    ItemLayoutWeatherBinding itemLayoutWeatherBinding;
    public WeatherListViewHolder(@NonNull ItemLayoutWeatherBinding itemLayoutWeatherBinding) {
        super(itemLayoutWeatherBinding.getRoot());
        this.itemLayoutWeatherBinding = itemLayoutWeatherBinding;
    }
    public void bind(WeatherInfo weatherInfo){
        itemLayoutWeatherBinding.setItemViemModel(weatherInfo);
        itemLayoutWeatherBinding.executePendingBindings();
    }
}
