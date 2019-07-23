package com.practice.weatherappusingmvvmdatabinding.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.practice.weatherappusingmvvmdatabinding.models.WeatherInfo;
import com.practice.weatherappusingmvvmdatabinding.R;
import com.practice.weatherappusingmvvmdatabinding.databinding.ItemLayoutWeatherBinding;
import com.practice.weatherappusingmvvmdatabinding.viewmodel.WeatherItemViewModel;

import java.util.List;

public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListViewHolder> {

    List<WeatherItemViewModel> dataToBeRendered;
    LayoutInflater inflater ;
    public WeatherListAdapter(List<WeatherItemViewModel> dataToBeRendered){
        this.dataToBeRendered = dataToBeRendered;
    }

    @NonNull
    @Override
    public WeatherListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        inflater = LayoutInflater.from(viewGroup.getContext());
        ItemLayoutWeatherBinding itemLayoutWeatherBinding = DataBindingUtil.inflate(inflater, R.layout.item_layout_weather,viewGroup,false);
        return new WeatherListViewHolder(itemLayoutWeatherBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherListViewHolder weatherListViewHolder, int i) {
        WeatherItemViewModel weatherInfo = dataToBeRendered.get(i);
        weatherListViewHolder.bind(weatherInfo);
    }

    @Override
    public int getItemCount() {
        return dataToBeRendered.size();
    }

}
