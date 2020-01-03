package com.javarush.task.task18.task1820;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();
        FileInputStream in = new FileInputStream(filename1);
        byte[] buf = new byte[in.available()];
        while (in.available() > 0) {int x = in.read(buf);}
        in.close();
        StringBuilder sb = new StringBuilder();
        for (byte b : buf){sb.append((char)b);}
        String bigString = sb.toString();
        String[] values = bigString.split(" ");
        StringBuilder sb2 = new StringBuilder();
        FileOutputStream file = new FileOutputStream(filename2);
        for (String s:values) {sb2.append((int)Math.round(Double.parseDouble(s))).append(" ");}
        sb2.deleteCharAt(sb2.length()-1);
        file.write(sb2.toString().getBytes());
        file.close();
    }
}
