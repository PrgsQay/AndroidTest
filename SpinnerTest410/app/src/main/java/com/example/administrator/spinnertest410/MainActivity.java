package com.example.administrator.spinnertest410;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvinfo;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //定义数据源
        String[] cities={"北京","上海","天津","大连"};
        //实例化ArrayAdapter
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,cities);
        //设置下拉按钮样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将spinner 与ArrayAdapter绑定spinner.setAdapter(adapter);

        spinner.setPrompt("请选择城市");//spinnew对画框设的标题

        //条目选择事件

        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvinfo.setText("您选择的是："+parent.getItemAtPosition(position).toString());
            }
        });
    }
    private void init(){
        tvinfo = (TextView) findViewById(R.id.textView);
        spinner = (Spinner) findViewById(R.id.spinner);
    }

}
