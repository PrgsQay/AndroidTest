package com.example.administrator.recyclerviewtest410scl.iface;

/**
 * Created by Administrator on 2017/4/18.
 */

public interface Articleiface {
    //获取文章列表
    void getResoutList(String mod,//模块
                       int page,//页数
                       String sessionID,
                       ArticleListener articleListener
                        );
}
