package com.practice.weatherappusingmvvmdatabinding.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.practice.weatherappusingmvvmdatabinding.databinding.ItemLayoutWeatherBinding;
import com.practice.weatherappusingmvvmdatabinding.viewmodel.WeatherItemViewModel;

class WeatherListViewHolder extends RecyclerView.ViewHolder {
    ItemLayoutWeatherBinding itemLayoutWeatherBinding;
    public WeatherListViewHolder(@NonNull ItemLayoutWeatherBinding itemLayoutWeatherBinding) {
        super(itemLayoutWeatherBinding.getRoot());
        this.itemLayoutWeatherBinding = itemLayoutWeatherBinding;
    }
    public void bind(WeatherItemViewModel weatherItemViewModel){
        itemLayoutWeatherBinding.setItemViemModel(weatherItemViewModel);
        itemLayoutWeatherBinding.executePendingBindings();
    }
}
