package com.example.administrator.XML;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${ljy} on 2016/11/11.
 */

public class PullBookParser {
    public List<Book> parse(InputStream inputStream) throws XmlPullParserException, IOException {
        List<Book> books = null;
        Book book = null;
        XmlPullParser parser = Xml.newPullParser();

        parser.setInput(inputStream,"UTF-8");

        int eventType = parser.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT){
            switch (eventType){
                case XmlPullParser.START_DOCUMENT:
                    books = new ArrayList<>();
               break;
                case XmlPullParser.START_TAG:
                    if (parser.getName().equals("book")){
                        book = new Book();
                    }else if (parser.getName().equals("id")){
                        eventType = parser.next();
                        book.setId(parser.getText());
                    }else if (parser.getName().equals("name")){
                        eventType = parser.next();
                        book.setName(parser.getText());
                    }else if (parser.getName().equals("price")){
                        eventType = parser.next();
                        book.setPrice(Float.parseFloat(parser.getText()));
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if (parser.getName().equals("book")){
                        books.add(book);
                    }
                    break;
            }
            eventType = parser.next();
        }

        return books;
    }
}
