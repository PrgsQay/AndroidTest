package com.example.administrator.widgettest410scl;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv;
    private EditText et;
    private Button btngettext, btnsetimg;
    private ImageView iv;
    private ImageButton ibtn;
    private RadioGroup rg;
    private RadioButton rbnan,rbnv;
    private CheckBox cblan,cbzu,cbyou;
    private Button btngetgender,btngetfun;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void init() {
        //获取六个控件
        tv = (TextView) findViewById(R.id.textView2);
        et = (EditText) findViewById(R.id.editText3);
        btngettext = (Button) findViewById(R.id.button);
        btnsetimg = (Button) findViewById(R.id.button2);
        iv = (ImageView) findViewById(R.id.imageView);
        ibtn = (ImageButton) findViewById(R.id.imageButton4);
        rg=(RadioGroup)findViewById(R.id.radiogroup);
        rbnan=(RadioButton) findViewById(R.id.radioButton2);
        rbnv=(RadioButton)findViewById(R.id.radioButton);
        cblan=(CheckBox) findViewById(R.id.checkBox5);
        cbzu=(CheckBox) findViewById(R.id.checkBox4);
        cbyou=(CheckBox) findViewById(R.id.checkBox3);
        btngetgender=(Button) findViewById(R.id.button4);
        btngetfun=(Button) findViewById(R.id.button5);

        //设置监听器
        btngettext.setOnClickListener(this);
        btnsetimg.setOnClickListener(this);
        ibtn.setOnClickListener(this);
        btngetgender.setOnClickListener(this);
        btngetfun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button ://设置文本
                String str=et.getText().toString();
                tv.setText(str);
                break;
            case R.id.button2 ://设置图片
                iv.setImageResource(R.drawable.user2);
                break;
            case R.id.imageButton4 ://图片按钮
            Intent intent=new Intent(MainActivity.this,NewActivity.class);
                intent.putExtra("param1",et.getText().toString());
                intent.putExtra("param2",3);
            startActivity(intent);
                 break;
            case R.id.button4://获取性别
                if(rbnan.isChecked()) tv.setText("男");
                if(rbnv.isChecked()) tv.setText("女");
                break;
            case R.id.button5://获取兴趣
                String msg="";
                if (cblan.isChecked()) msg+="篮球";
                if (cbzu.isChecked()) msg+="足球";
                if (cbyou.isChecked()) msg+="游泳";
                tv.setText(msg);
                break;
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
