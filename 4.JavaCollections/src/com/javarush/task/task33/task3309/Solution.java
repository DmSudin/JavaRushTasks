package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(obj, writer);
        String xml = writer.toString();
        String replaced = "<" + tagName + ">";
        String required = "<!--" + comment + "-->\n" + replaced;
        String result = xml.replaceAll(replaced, required);

        return result;
    }

    public static void main(String[] args) {

    }
}
