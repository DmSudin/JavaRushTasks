package com.javarush.task.task18.task1826;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        //String[] argums = args[0].split(" ");
        String inputName = args[1];
        String outputName = args[2];
        String parameter = args[0];
        byte[] buf;
        FileInputStream fis = new FileInputStream(inputName);
        FileOutputStream fos = new FileOutputStream(outputName);
        buf = new byte[fis.available()];
        while (fis.available() > 0) {fis.read(buf);}
        fis.close();
        for (byte b: buf) {
            if (parameter.equals("-e"))fos.write(b+3);
            else fos.write(b-3);
        }
        fos.close();
    }

}
