package com.javarush.task.task33.task3309;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, ParserConfigurationException, IOException, SAXException, TransformerException {
        StringWriter stringWriter = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(obj, stringWriter);

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new InputSource(new StringReader(stringWriter.toString())));
//        document.getDocumentElement().normalize();

        NodeList nodeList = document.getDocumentElement().getElementsByTagName(tagName);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            node.getParentNode().insertBefore(document.createComment(comment), node);
        }
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
//        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(document), new StreamResult(writer));
        String output = writer.toString();
        return output;
    }

    public static void main(String[] args) throws JAXBException, IOException, SAXException, ParserConfigurationException, TransformerException {
        Shop shop = new Shop();
        shop.count = 12;
        shop.profit = 1234.5;
        shop.goods = new Shop.Goods();
        shop.goods.names.add("names1");
        shop.goods.names.add("names2");
        shop.secretData[0] = "sD1";
        shop.secretData[1] = "sD2";
        shop.secretData[2] = "sD3";
        shop.secretData[3] = "sD4";
        shop.secretData[4] = "sD5";
        
        StringWriter stringWriter = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Shop.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(shop, stringWriter);

        System.out.println(stringWriter.toString());
        System.out.println("XmlWithComments");
        System.out.println(toXmlWithComment(shop, "profit", "this is a comment!!!"));

    }
}
