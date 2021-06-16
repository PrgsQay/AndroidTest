package com.example.administrator.recyclerviewtest410scl.iface;

import com.example.administrator.recyclerviewtest410scl.bean.ArticleBean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/18.
 */

public interface ArticleListener {
    //成功返回文章列表信息
    void onResponse(List<ArticleBean> list);
    //失败返回错误字符串
    void onFail(String msg);

}
