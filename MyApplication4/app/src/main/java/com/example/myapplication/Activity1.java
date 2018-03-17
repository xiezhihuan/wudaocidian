package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Activity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        //点击登陆键，跳转到第二页面
        ImageButton bt_denglu=(ImageButton) findViewById(R.id.bt_denglu);
        bt_denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity1.this,Activity2.class);
                startActivity(intent);
            }
        });

        //点击“服务条款”，进入到百度首页
        TextView fuwutiaokuan=(TextView) findViewById(R.id.fuwutiaokuan);
        fuwutiaokuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

    }
}
