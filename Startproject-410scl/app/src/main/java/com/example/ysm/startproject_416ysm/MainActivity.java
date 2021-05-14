package com.example.ysm.startproject_416ysm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.WrapperListAdapter;

import com.example.ysm.startproject_416ysm.bean.WeatherInfo;
import com.example.ysm.startproject_416ysm.iface.WeatherListner;
import com.example.ysm.startproject_416ysm.model.Weather51Model;
import com.example.ysm.startproject_416ysm.model.WeatherModel;

public class MainActivity extends AppCompatActivity implements WeatherListner, View.OnClickListener{


    private EditText etcityno;
    private Button btnfind2,btnfind3;
    private TextView txeityname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
    private void init(){
        etcityno = (EditText)findViewById(R.id.editText);
        btnfind2 = (Button) findViewById(R.id.button);
        btnfind3 = (Button) findViewById(R.id.button);
        txeityname = (TextView) findViewById(R.id.textView5);
        btnfind2.setOnClickListener(this);
        btnfind3.setOnClickListener(this);

    }

    @Override
    public void onResponse(WeatherInfo weatherInfo) {
     if(weatherInfo!=null){
         txeityname.setText(weatherInfo.getCity());
     }
        else{
         txeityname.setText("未知");
     }
    }

    @Override
    public void onFail(String msg) {
        txeityname.setText(msg);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.button://查询1
                WeatherModel weatherModel=new WeatherModel();
                weatherModel.getweather(etcityno.getText().toString(),this);
                break;
            case R.id.button2://查询2
                Weather51Model weather51Model = new Weather51Model();
                weather51Model.getweather(etcityno.getText().toString(),this);
                break;
            default:
                break;
        }
    }
}
