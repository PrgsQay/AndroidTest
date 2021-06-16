package com.example.administrator.recyclerviewtest410scl.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.recyclerviewtest410scl.R;
import com.example.administrator.recyclerviewtest410scl.bean.ArticleBean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/13.
 */

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;//上下文
    private  LayoutInflater layoutInflater;//动态加载布局
    private  List<ArticleBean> list;//保存要显示的数据
    //自定义：构造方法；传进上下文
    public MyAdapter(Context context){
        this.context=context;
        layoutInflater= LayoutInflater.from(context);
    }
    //自定义：获取数据
    public void setList(List<ArticleBean> list){
        this.list=list;
    }
    //自定义;ViewHolder子类
    public class  ViewHolder extends  RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView tvtitle,tvdescrrpt,tvtime;
        private Button button;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.imageView);
            tvtitle=(TextView)itemView.findViewById(R.id.textView);
            tvdescrrpt=(TextView)itemView.findViewById(R.id.textView2);
            tvtime=(TextView)itemView.findViewById(R.id.textView3);
            button=(Button) itemView.findViewById(R.id.button);
        }
    }
    //重写：生成Item的View
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=layoutInflater.inflate(R.layout.item,parent,false);
        return new ViewHolder(v);
    }
    //重写：给ViewHolder中的控件填充值，设置监听
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ArticleBean articleBean=list.get(position);
        if(articleBean==null)
            return;
        ViewHolder viewHolder=(ViewHolder)holder;
        viewHolder.imageView.setImageResource(Integer.parseInt(articleBean.getThumb()));
        viewHolder.tvtitle.setText(articleBean.getName());
        viewHolder.tvdescrrpt.setText(articleBean.getDescription());
        viewHolder.tvtime.setText(articleBean.getUpdate_time());
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();//更新RecyclerView
                //在实际案列中，要删除应该涉及网络或数据库访问
                //一般要有删除前的提醒

            }
        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取当前条目信息，如id
                int id=list.get(position).getId();
                Toast.makeText(context,""+id,Toast.LENGTH_SHORT).show();
                //实际中，点击后打开新窗口做其他操作
            }
        });

    }
    //共用多少条目
    @Override
    public int getItemCount() {
        return list.size();
    }
}
