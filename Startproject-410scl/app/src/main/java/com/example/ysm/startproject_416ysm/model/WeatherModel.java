package com.example.ysm.startproject_416ysm.model;

import com.example.ysm.startproject_416ysm.MainActivity;
import com.example.ysm.startproject_416ysm.Service.WeatherService;
import com.example.ysm.startproject_416ysm.bean.WeatherResult;
import com.example.ysm.startproject_416ysm.iface.WeatherIface;
import com.example.ysm.startproject_416ysm.iface.WeatherListner;
import com.google.gson.Gson;
import com.squareup.picasso.Callback;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ysm on 2017/3/14.
 */

public class WeatherModel implements WeatherIface {
    private Retrofit retrofit;
    private String BASEURL="http://www.weather.com.cn /";
    public WeatherModel() {
        System.out.println("****Weathermodel getweather");
        //Retrofit实例化 3-1
        retrofit= new Retrofit.Builder().baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Override
    public void getweather(String cityno, final WeatherListner listner) {
        //Retrofit接口使用 3-2
        WeatherService weatherService =
                retrofit.create(WeatherService.class);
        Call<WeatherResult> call =
                weatherService.getResult(cityno);
        //Retrofit接口使用 3-3
        call.enqueue(new retrofit2.Callback<WeatherResult>() {
            @Override
            public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {
                System.out.println("*****weather*****onrepeonse");
                if(response.isSuccessful() && response.body()!=null){
                    listner.onResponse(response.body().getWeatherinfo());
                } else{
                    listner.onFail("onResponse error");
                }
            }

            @Override
            public void onFailure(Call<WeatherResult> call, Throwable t) {
                System.out.println("*****weather*****onfail");
                listner.onFail(t.toString());
            }
        });
    }

}
