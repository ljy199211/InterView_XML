package com.example.administrator.json;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.administrator.interview_xml.R;
import com.example.administrator.net.MyClient;
import com.example.administrator.result.SearchResult;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JsonActivity extends AppCompatActivity implements View.OnClickListener {
    private static String JSON = "{\n" +
            "    \"resultcode\": \"200\",\n" +
            "    \"reason\": \"SUCCESSED!\",\n" +
            "    \"result\": [\n" +
            "        {\n" +
            "            \"city\": \"苏州\",  /*城市*/\n" +
            "            \"PM2.5\": \"73\",  /*PM2.5指数*/\n" +
            "            \"AQI\": \"98\",    /*空气质量指数*/\n" +
            "            \"quality\": \"良\", /*空气质量*/\n" +
            "            \"PM10\": \"50\",/*PM10*/\n" +
            "            \"CO\": \"0.79\",  /*一氧化碳*/\n" +
            "            \"NO2\": \"65\",  /*二氧化氮*/\n" +
            "            \"O3\": \"28\",    /*臭氧*/\n" +
            "            \"SO2\": \"41\",  /*二氧化硫*/\n" +
            "            \"time\": \"2014-12-26 11:48:40\"/*更新时间*/  \n" +
            "        }\n" +
            "    ],\n" +
            "    \"error_code\": 0\n" +
            "}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        Button btn_json = (Button) findViewById(R.id.btn_json);
        btn_json.setOnClickListener(this);
        MyClient.getInstance().getAir("","").enqueue(callback);

    }
    private Callback<SearchResult> callback = new Callback<SearchResult>() {
        @Override
        public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {

        }

        @Override
        public void onFailure(Call<SearchResult> call, Throwable t) {

        }
    };

    @Override
    public void onClick(View v) {

       /* try {
            JSONObject obj = new JSONObject(JSON);
            String resultcode = obj.getString("resultcode");
            Log.d("Json", "resultcode = "+resultcode);
            String reason = obj.getString("reason");
            Log.d("Json", "reason = "+reason);
            String error_code = obj.getString("error_code");
            Log.d("Json", "error_code = "+error_code);
            JSONArray result = obj.getJSONArray("result");
            for (int i=0;i<result.length();i++){
                JSONObject jsonObject = result.getJSONObject(i);
                Log.d("Json", "jsonObject = "+jsonObject.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
        Gson gson = new Gson();

        JsonInfor object = gson.fromJson(JSON,JsonInfor.class);
        Log.d("Json", "jsonObject = "+object.toString());
    }
}
