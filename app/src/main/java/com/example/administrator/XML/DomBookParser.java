package com.example.administrator.XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by ${ljy} on 2016/11/11.
 */

public class DomBookParser {
    public List<Book> domParser(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();

        Document doc = documentBuilder.parse(inputStream);

        Element rootElement = doc.getDocumentElement();

        NodeList items = rootElement.getElementsByTagName("book");

        List<Book> books = new ArrayList<>();
        for (int i = 0; i < items.getLength(); i++) {
            Book book = new Book();
            Node item = items.item(i);
            for (int k = 0; k <item.getAttributes().getLength() ; k++) {
                if (item.getAttributes().item(k).getNodeName().equals("id")){
                    String nodeValue = item.getAttributes().item(k).getNodeValue();
                    book.setId(nodeValue);
                }
            }
            NodeList properties = item.getChildNodes();
            for (int j = 0; j < properties.getLength(); j++) {
                Node property = properties.item(j);
                String nodeName = property.getNodeName();
                if (nodeName.equals("id")) {
                    book.setId(property.getFirstChild().getNodeValue());
                } else if (nodeName.equals("name")) {
                    book.setName(property.getFirstChild().getNodeValue());
                } else if (nodeName.equals("price")) {
                    book.setPrice(Double.parseDouble(property.getFirstChild().getNodeValue()));
                }


            }
            books.add(book);
        }
        return books;

    }
}
