package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;


public class Activity3 extends Activity {
    String s;
    JSONArray jsonArray;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Button bt_wangluoqingqiu = (Button) findViewById(R.id.fasongwangluoqingqiu);
        bt_wangluoqingqiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //发送网络请求
                        s = Http.sendPost("http://47.94.227.99/Amazon/login", "uPhone=123&upassword=123");
                        Log.d(TAG, "result=" + s);
                    }
                }).start();
            }
        });

//        Button bt_dayinshuju = (Button) findViewById(R.id.dayinshuju);
//        bt_dayinshuju.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                parseJSONWithJSONObject(s);
//                Gson gson = new Gson();
//                shuju shuju = gson.fromJson(s,shuju.class);
//                Toast.makeText(Activity3.this,shuju.status,Toast.LENGTH_SHORT);
//
//
//
//            }
//        });

        //注册“查询”按钮
        Button bt_chaxun = (Button) findViewById(R.id.chaxun);
        bt_chaxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //发送网络请求
                        String s = Http.get(
                                "http://api.fanyi.baidu.com/api/trans/vip/translate?q=good&from=en&to=zh&appid=20180401000142028&salt=1345660288&sign=617a9a702847c691314475734bbea7b7");
                        Log.d(TAG, "result=" + s);
                        Http.parse(s);

                    }
                }).start();
            }
        });


    }

    private void parseJSONWithJSONObject(String jsonData){
        try {
            //将json字符串jsonData装入JSON数组，即JSONArray
            //jsonData可以是从文件中读取，也可以从服务器端获得
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0; i< jsonArray.length(); i++) {
                //循环遍历，依次取出JSONObject对象
                //用getInt和getString方法取出对应键值
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int stu_no = jsonObject.getInt("stu_no");
                String stu_name = jsonObject.getString("stu_name");
                String stu_sex = jsonObject.getString("stu_sex");
                Log.d("MainActivity","stu_no: " + stu_no);
                Log.d("MainActivity","stu_name: " + stu_name);
                Log.d("MainActivity","stu_sex: " + stu_sex);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class shuju{
    String status;
    String msg;
    String data;

    shuju(String status,String msg,String data){
    this.status = status;
    this.msg = msg;
    this.data = data;
    }
}



