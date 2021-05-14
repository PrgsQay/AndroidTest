package com.example.ysm.startproject_416ysm.model;

import com.example.ysm.startproject_416ysm.Service.Weather51Service;
import com.example.ysm.startproject_416ysm.Service.WeatherService;
import com.example.ysm.startproject_416ysm.bean.WeatherResult;
import com.example.ysm.startproject_416ysm.iface.WeatherIface;
import com.example.ysm.startproject_416ysm.iface.WeatherListner;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ysm on 2017/3/14.
 */

public class Weather51Model implements WeatherIface{
    private Retrofit retrofit;
    private String BASEURL="http://weather.51wnl.com/weatherinfo/";
    public Weather51Model() {
        System.out.println("****Weathermodel getweather");
//Retrofit实例化 3-1
        retrofit= new Retrofit.Builder().baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }
    

    @Override
    public void getweather(String cityno, final WeatherListner listner) {
        Weather51Service weather51Service =
                retrofit.create(Weather51Service.class) ;
        Call<WeatherResult> call =
                weather51Service.getResult(cityno,1);

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
