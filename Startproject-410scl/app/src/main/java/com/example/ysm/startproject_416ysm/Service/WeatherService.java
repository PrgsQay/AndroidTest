package com.example.ysm.startproject_416ysm.Service;

import com.example.ysm.startproject_416ysm.bean.WeatherResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ysm on 2017/3/14.
 */
//访问网络，定义接口。
public interface WeatherService {

    @GET("data/sk/{cityNumber}.html")
    Call<WeatherResult> getResult(@Path("cityNumber")String cityNumber);
}
