package com.example.ysm.startproject_416ysm.iface;

import com.example.ysm.startproject_416ysm.bean.WeatherInfo;

/**
 * Created by ysm on 2017/3/14.
 */

public interface WeatherListner {
    //成功返回天气信息
    void onResponse(WeatherInfo weatherInfo);
    //失败返回天气信息
    void onFail(String msg);

}
