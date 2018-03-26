package com.example.myapplication;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by 谢植焕 on 2018/3/25.
 */

public class JSONObject1 {
    private void parseJSONWithJSONObject(String jsonDate){
        try {
            JSONArray jsonArray = new JSONArray(jsonDate);
            for (int i = 0; i <jsonArray.length() ; i++) {
                org.json.JSONObject jsonObject = jsonArray.getJSONObject(i);
                String status = jsonObject.getString("status");
                String msg = jsonObject.getString("msg");
                String data = jsonObject.getString("data");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
