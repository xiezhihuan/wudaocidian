package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //注册菜单图标的的点击事件
        ImageButton bt_menu= (ImageButton) findViewById(R.id.bt);
        bt_menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity2.this,"你点击了菜单",Toast.LENGTH_SHORT).show();
            }
        });

        //注册撤销活动键X
        ImageButton bt_x= (ImageButton) findViewById(R.id.bt_x);
        bt_x.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //通过点击图片按钮“小学”进入第二个页面
        ImageButton bt_xiaoxue=(ImageButton) findViewById(R.id.bt_xiaoxue);
        bt_xiaoxue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity2.this,Activity3.class);
                startActivity(intent);
            }
        });

        //点击“初中”，进行拨号  //LinearLayout的整体点击
        LinearLayout chuzhong=(LinearLayout) findViewById(R.id.L_chuzhong);
        chuzhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:13457916656"));
                startActivity(intent);
            }
        });

        //zhuc
        //注册侧滑菜单里item的点击事件

    }

}
