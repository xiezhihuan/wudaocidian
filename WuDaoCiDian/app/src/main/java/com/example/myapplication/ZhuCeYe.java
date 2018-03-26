package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by 谢植焕 on 2018/3/25.
 */


public class ZhuCeYe extends Activity {

    private static final String TAG = "ZhuCeYe";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuceye);

        //获取“name”
        EditText editText1 = (EditText) findViewById(R.id.signin_name);
        String name = editText1.getText().toString();

        //获取“phone”
        EditText editText2 = (EditText) findViewById(R.id.signin_phone);
        String phone = editText2.getText().toString();

        //获取“password”
        EditText editText3 = (EditText) findViewById(R.id.signin_password);
        String password = editText3.getText().toString();

        //注册“确定”
        Button bt_queding = (Button) findViewById(R.id.signin_queding);
        bt_queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //提交“注册信息”的网络请求
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String s = Http.sendPost("http://47.94.227.99/Amazon/insertUser", "uName=name&uPhone=phone&uPassword=password");
                        Log.d(TAG, "result="+s);
                    }
                }).start();
                //跳转到“短信验证页面”
                Intent intent = new Intent(ZhuCeYe.this,Signin_yanzhengye.class);
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
                .setName("ZhuCeYe Page") // TODO: Define a title for the content shown.
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
