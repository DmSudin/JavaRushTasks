package com.javarush.task.task32.task3213;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
/* Шифр Цезаря*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        if (reader == null) return new String();
        StringBuffer str = new StringBuffer();
        int i;
        while ((i = reader.read()) !=-1) {
            str.append((char)(i+key));
        }
        reader.close();
        System.out.println(str.toString());
        return str.toString();
    }
}
