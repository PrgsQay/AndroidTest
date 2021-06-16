package com.example.administrator.recyclerviewtest410scl.service;

import com.example.administrator.recyclerviewtest410scl.bean.ArticleBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/4/18.
 */

public interface ArticleService {
    @GET("api.php/lists/mod/{mod}")
    Call<List<ArticleBean>> getResult(
            @Path("mod")String mod,
            @Path("page")int page,
            @Path("SessionID")String SessionID
    );

}
