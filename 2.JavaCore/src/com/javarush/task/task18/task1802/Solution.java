package com.javarush.task.task18.task1802;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        FileInputStream file = new FileInputStream(filename);
        int minByte = Integer.MAX_VALUE;
        while (file.available() > 0) {
            int element = file.read();
            if (element < minByte) minByte = element;
        }
        System.out.println(minByte);
        file.close();
    }

}
