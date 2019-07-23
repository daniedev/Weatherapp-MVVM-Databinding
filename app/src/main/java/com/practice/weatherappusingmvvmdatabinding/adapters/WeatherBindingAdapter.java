package com.practice.weatherappusingmvvmdatabinding.adapters;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class WeatherBindingAdapter {

    @BindingAdapter("fetchImage")
    public static void fetchImage(ImageView imageView, String imageUrl) {
        String url = "http://openweathermap.org/img/w/".concat(imageUrl).concat(".png");
        Picasso.get()
                .load(url)
                .into(imageView);
    }

}
