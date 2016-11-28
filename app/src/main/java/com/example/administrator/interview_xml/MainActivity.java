package com.example.administrator.interview_xml;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.XML.XMLActivity;
import com.example.administrator.json.JsonActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lv_main;
    private String[] datas;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_main = (ListView) findViewById(R.id.lv_main);
        datas = new String[]{
                "XML解析",
                "Json解析",
                "Html解析"
        };
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, datas);

        lv_main.setAdapter(adapter);
        lv_main.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(MainActivity.this, XMLActivity.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, JsonActivity.class));
                break;
            case 2:
                break;
        }
    }
}
