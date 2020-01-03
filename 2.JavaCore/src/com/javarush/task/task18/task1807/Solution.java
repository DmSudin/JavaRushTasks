package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int counter = 0;
        String fileName = reader.readLine();
        reader.close();
        FileInputStream input = new FileInputStream(fileName);
        while (input.available() > 0) {
            byte element = (byte)input.read();
            if (element == 44) counter++;
        }
        input.close();
        System.out.println(counter);

    }
}
