package com.javarush.task.task18.task1801;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        int maxByte = 0;
        FileInputStream file = new FileInputStream(filename);
        while (file.available() > 0) {
            int element = file.read();
            if (maxByte < element) maxByte = element;
        }
        System.out.println(maxByte);
        file.close();
    }
}
