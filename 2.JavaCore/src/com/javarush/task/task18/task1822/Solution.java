package com.javarush.task.task18.task1822;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        FileInputStream file = new FileInputStream(filename);
        byte[] buf = new byte[file.available()];
        while (file.available() > 0) {int x = file.read(buf);}
        file.close();
        StringBuilder sb = new StringBuilder();
        for (byte b:buf) { sb.append((char)b); }
        List<String> strings = Arrays.asList(sb.toString().split(System.lineSeparator()));
        for (String s : strings) {
            if (s.startsWith(args[0] + " ")){
            System.out.println(s);
            //break;
            }
        }

    }
}
