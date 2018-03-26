package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by 谢植焕 on 2018/3/25.
 */

public class Signin_yanzhengye extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yanzhengye);

        //注册点击“确定”
        Button bt_queding = (Button) findViewById(R.id.yanzhengye_queding);
        bt_queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转回“登陆页”
                Intent intent = new Intent(Signin_yanzhengye.this, Activity1.class);
                startActivity(intent);
                //结束当前页
                finish();
            }
        });
    }
}
