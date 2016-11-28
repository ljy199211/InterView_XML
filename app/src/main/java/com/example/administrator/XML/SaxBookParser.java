package com.example.administrator.XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by ${ljy} on 2016/11/10.
 */

public class SaxBookParser {
    public List<Book> saxParser(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        SAXParser saxParser = saxParserFactory.newSAXParser();
        MyHandler myHandler = new MyHandler();

        saxParser.parse(inputStream, myHandler);
        return myHandler.getBooks();

    }

    private class MyHandler extends DefaultHandler {
        private List<Book> books;
        private Book book;
        private StringBuilder builder;

        @Override
        public void startDocument() throws SAXException {
            super.startDocument();
            books = new ArrayList<>();
            builder = new StringBuilder();
        }

        public List<Book> getBooks() {
            return books;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            super.startElement(uri, localName, qName, attributes);
            if (localName.equals("book")){
                book = new Book();
                for (int i = 0; i <attributes.getLength() ; i++) {
                    if (attributes.getQName(i).equals("id")){
                        String value = attributes.getValue(i);
                        book.setId(value);
                    }
                }
            }
            builder.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            super.characters(ch, start, length);
            builder.append(ch,start,length);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            super.endElement(uri, localName, qName);
            if (localName.equals("id")){
                book.setId(builder.toString());
            }else if(localName.equals("name")){
                book.setName(builder.toString());
            }else if (localName.equals("price")){
                book.setPrice(Double.parseDouble(builder.toString()));
            }else if (localName.equals("book")){
                books.add(book);
            }
        }

    }
}
