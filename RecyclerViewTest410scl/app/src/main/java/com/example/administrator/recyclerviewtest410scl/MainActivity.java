package com.example.administrator.recyclerviewtest410scl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private  RecyclerView.LayoutManager layoutManager;//显示布局效果
    private  MyAdapter myAdapter;//适配器
    private List<ArticleBean> list=null;//数据源

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }
    private void initRecyclerView() {
        //获取RecyclerView，设置属性，获取数据源，绑定
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        //创建默认的线性布局
        layoutManager=new LinearLayoutManager(this);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //固定每个item高度，提高性能
        recyclerView.setHasFixedSize(true);
        //获取数据并创建Adaper
        list=getData();
        myAdapter=new MyAdapter(this);
        myAdapter.setList(list);
        //绑定RecycleView和adaper
        recyclerView.setAdapter(myAdapter);
    }

    //自定义：获取数据并形成list
    private  List<ArticleBean> getData(){
        //定义List,赋值，返回
        List<ArticleBean> list=new ArrayList<ArticleBean>();
        ArticleBean articleBean;
        //第一组模拟数据
        articleBean=new ArticleBean();
        articleBean.setArticleId(1);
        articleBean.setTitle("标题1");
        articleBean.setDescription("描述 ");
        articleBean.setTime("2017-4-1");
        articleBean.setImgid(R.drawable.f1);
        list.add(articleBean);
        articleBean=new ArticleBean();
        articleBean.setArticleId(2);
        articleBean.setTitle("标题2");
        articleBean.setDescription("描述 ");
        articleBean.setTime("2017-4-2");
        articleBean.setImgid(R.drawable.f2);
        list.add(articleBean);
        articleBean=new ArticleBean();
        articleBean.setArticleId(3);
        articleBean.setTitle("标题3");
        articleBean.setDescription("描述 ");
        articleBean.setTime("2017-4-3");
        articleBean.setImgid(R.drawable.f3);
        list.add(articleBean);
        articleBean=new ArticleBean();
        articleBean.setArticleId(4);
        articleBean.setTitle("标题4");
        articleBean.setDescription("描述 ");
        articleBean.setTime("2017-4-4");
        articleBean.setImgid(R.drawable.f4);
        list.add(articleBean);
        articleBean=new ArticleBean();
        articleBean.setArticleId(5);
        articleBean.setTitle("标题5");
        articleBean.setDescription("描述 ");
        articleBean.setTime("2017-4-5");
        articleBean.setImgid(R.drawable.f5);
        list.add(articleBean);
        articleBean=new ArticleBean();
        articleBean.setArticleId(6);
        articleBean.setTitle("标题6");
        articleBean.setDescription("描述 ");
        articleBean.setTime("2017-4-6");
        articleBean.setImgid(R.drawable.f6);
        list.add(articleBean);
        return  list;
    }
}
