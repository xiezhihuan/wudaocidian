package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class Activity1 extends Activity {
    private static final String TAG = "Activity1";

    private GoogleApiClient client;

    //把定义“phone”“password”定义为全局变量(因为局部变量在此处不可用)
    String phone;
    String password;

    //post请求的返回数据
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        //点击“新用户注册”
        TextView tv_zhuce = (TextView) findViewById(R.id.zhuce);
        tv_zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity1.this, ZhuCeYe.class);
                startActivity(intent);
            }
        });



        //点击“登陆”，获取“phone”和“password”输入的内容，提交网络请求后，跳转到第二页面
        ImageButton bt_denglu = (ImageButton) findViewById(R.id.bt_denglu);
        bt_denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //获取“phone”内容
                EditText editText_phone = (EditText) findViewById(R.id.login_phone);
                phone = editText_phone.getText().toString();

                //获取“password”内容
                EditText editText_password = (EditText) findViewById(R.id.login_password);
                password = editText_password.getText().toString();

                //如果“phone”“password”不为空，才会跳转到“主页”
                if (!"".equals(phone) && !"".equals(password) && phone != null && password != null) {
                    //如果条件成立，则判断“是否存在该账号”“密码是否正确”
                    //   int flag=1;``
                    // String a=s[0];
                    //if (a)
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //发送网络请求
                            s = Http.sendPost("http://47.94.227.99/Amazon/login", "uPhone=" + phone + "&uPassword=" + password);
                            Log.d(TAG, "result=" + s);
                        }
                    }).start();

                    //跳转到“主页”
                    Intent intent = new Intent(Activity1.this, Activity2.class);
                    startActivity(intent);
                }else if("".equals(phone)){
                    Toast.makeText(Activity1.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                }else if("".equals(password)){
                    Toast.makeText(Activity1.this, "请输入密码", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Activity1.this, "xzh:检测到异常", Toast.LENGTH_SHORT).show();
                }

            }






        });

        //点击“服务条款”，进入到百度首页
        TextView fuwutiaokuan = (TextView) findViewById(R.id.fuwutiaokuan);
        fuwutiaokuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Activity1 Page") // TODO: Define a title for the content shown.
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
