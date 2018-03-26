package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        //注册菜单图标的的点击事件,点击菜单弹出侧滑菜单
        final DrawerLayout mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        final ImageButton bt_menu= (ImageButton) findViewById(R.id.bt);
        bt_menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);  //调用该方法打开“侧滑菜单”
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

        //注册侧滑菜单里item的点击事件

        NavigationView navigationView=(NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.item1:
                        //Toast.makeText(this,"你点击了笔记", Toast.LENGTH_SHORT).show();  为什么不能处理这条方法？
                    case R.id.item2:
                    case R.id.item3:
                        Intent intent3=new Intent(Intent.ACTION_DIAL);
                        intent3.setData(Uri.parse("tel:18810447748"));
                        startActivity(intent3);
                    case R.id.item4:
                    case R.id.item5:
                        mDrawerLayout.closeDrawers();
                }
                return true;
            }
        });
    }

}
