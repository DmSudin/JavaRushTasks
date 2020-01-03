package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();
        byte[] buf1, buf2;
        FileInputStream f1 = new FileInputStream(filename1);
        FileInputStream f2 = new FileInputStream(filename2);
        buf1 = new byte[f1.available()];
        buf2 = new byte[f2.available()];
        while (f1.available() > 0) {int x = f1.read(buf1);}
        while (f2.available() > 0) {int x = f2.read(buf2);}
        f1.close(); f2.close();
        FileOutputStream out = new FileOutputStream(filename1, false);
        out.write(buf2);
        out.write(buf1);
        out.close();



    }
}
