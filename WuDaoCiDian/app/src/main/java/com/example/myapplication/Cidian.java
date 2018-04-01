package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import static com.example.myapplication.MD5.md5;

/**
 * Created by 谢植焕 on 2018/4/1.
 */

public class Cidian extends Activity {

    private static final String TAG = "Cidian";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cidian);
        
        //注册“查询”按键
        Button bt_chaxun= (Button) findViewById(R.id.cidian_chaxun);
        bt_chaxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //获取“单词”
                        EditText input_word = (EditText) findViewById(R.id.cidian_input);
                        String word = input_word.getText().toString();
                        //设置salt“随机数”
                        String salt="602666178";
                        //密钥
                        String passKey="N7h_UHHaiu8NtR2gyW7y";
                        //获得签名“sign”
                        String pro_sign="20180401000142028"+word+salt+passKey;
                        String sign=md5(pro_sign);
                        //发送网络请求
                        String s = Http.get(
                                "http://api.fanyi.baidu.com/api/trans/vip/translate?q="+ word +"&from=en&to=zh&appid=20180401000142028&salt="+ salt +"&sign="+sign);
                        Http.parse(s);


                    }
                }).start();

    //将查询结果显示在“EditText”上
                EditText et_output = (EditText) findViewById(R.id.cidian_output);
                et_output.setText("原文:"+ Http.src +"     "+"译文:"+Http.dst);
                Log.d(TAG, "显示出来的代码"+Http.src);

            }
        });
    }
}
