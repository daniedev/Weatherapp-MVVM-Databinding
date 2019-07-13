package com.practice.weatherappusingmvvmdatabinding.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.practice.weatherappusingmvvmdatabinding.databinding.ActivityWeatherBinding;
import com.practice.weatherappusingmvvmdatabinding.models.WeatherInfo;
import com.practice.weatherappusingmvvmdatabinding.network.WeatherService;
import com.practice.weatherappusingmvvmdatabinding.network.RetrofitInstance;
import com.practice.weatherappusingmvvmdatabinding.view.weatherlistadapter.WeatherListAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel extends ViewModel implements LifecycleObserver {
    public WeatherListAdapter adapter;
    private WeatherService getData;
    private List<String> citiesToBePreLoaded ;
    public List<WeatherInfo> weatherInfoList;


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate(){
        weatherInfoList = new ArrayList<>();
        adapter = new WeatherListAdapter(weatherInfoList);
        generateListOfCitiesToBePreLoaded();
        establishNetworkLayerandPreLoadData();
        if(citiesToBePreLoaded !=null){
            fetchDataFromServer(citiesToBePreLoaded);
        }
    }



    public void generateListOfCitiesToBePreLoaded(){
        citiesToBePreLoaded = new ArrayList<>();
        citiesToBePreLoaded.add("chennai");
        citiesToBePreLoaded.add("mumbai");
        citiesToBePreLoaded.add("bangalore");
        citiesToBePreLoaded.add("delhi");
    }

    public void establishNetworkLayerandPreLoadData(){
        getData = new RetrofitInstance().getRetrofitInstance().create(WeatherService.class);

    }


    public void fetchDataFromServer(final List<String> listOfCities){
        for(String cityName : listOfCities){
        Call<WeatherInfo> networkCall = getData.getWeatherInfo(cityName,"metric");
        networkCall.enqueue(new Callback<WeatherInfo>() {
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                //simulateDelay(5);
                if (response.body() !=null) {
                    WeatherInfo weatherInfo = response.body();
                    weatherInfoList.add(response.body());
                    Log.d("Weather","Response--->"+weatherInfo);
                    adapter.notifyDataSetChanged();


                }

                if(citiesToBePreLoaded.size()==weatherInfoList.size()){
                   // setAdapter();
                }


            }

            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {
                //Toast.makeText(this,"error",2);

            }
        });

        }
    }



    public WeatherListAdapter getAdapter(){
        return adapter;

    }
    public void setAdapter(){
         adapter = new WeatherListAdapter(weatherInfoList);

    }


    public void simulateDelay(int delaytime){
        try{
            Thread.sleep(delaytime);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }



}
