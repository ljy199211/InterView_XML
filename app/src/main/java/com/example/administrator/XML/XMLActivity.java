package com.example.administrator.XML;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.administrator.interview_xml.R;

import java.io.InputStream;
import java.util.List;

public class XMLActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);
        Button btn_sax = (Button) findViewById(R.id.btn_sax);
        Button btn_dom = (Button) findViewById(R.id.btn_dom);
        Button btn_pull = (Button) findViewById(R.id.btn_pull);

        btn_sax.setOnClickListener(this);
        btn_dom.setOnClickListener(this);
        btn_pull.setOnClickListener(this);
    }

    private void domParse() {
        try {
            InputStream inputStream = getAssets().open("Books.xml");
            DomBookParser domBookParser = new DomBookParser();
            List<Book> books = domBookParser.domParser(inputStream);
            for (Book book : books
                    ) {
                Log.d("XMLActivity", "domParse: " + book.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void saxParse() {
        try {
            InputStream inputStream = getAssets().open("Books.xml");
            SaxBookParser saxBookParser = new SaxBookParser();
            List<Book> books = saxBookParser.saxParser(inputStream);
            for (Book book : books) {
                Log.d("XMLActivity", "saxParse: " + book.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void pullParse() {
        try {
            InputStream inputStream = getAssets().open("Books.xml");
            PullBookParser saxBookParser = new PullBookParser();
            List<Book> books = saxBookParser.parse(inputStream);
            for (Book book : books) {
                Log.d("XMLActivity", "pullParse: " + book.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sax:
                saxParse();
                break;
            case R.id.btn_dom:
                domParse();
                break;
            case R.id.btn_pull:
                pullParse();
                break;
        }

    }


}
