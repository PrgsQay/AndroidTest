package com.example.ysm.startproject_416ysm.Service;

import com.example.ysm.startproject_416ysm.bean.WeatherResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ysm on 2017/3/14.
 */
//Retrofit网络访问——2定义接口
public interface Weather51Service {
    @GET("GetMoreWeather")
    Call<WeatherResult> getResult(
            @Query("cityCode")String cityNumber,
            @Query("weatherType")int weatherType
    );
 }
