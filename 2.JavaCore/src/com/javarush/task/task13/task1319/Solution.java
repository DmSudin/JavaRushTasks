package com.javarush.task.task13.task1319;
import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String element;
        BufferedWriter file = new BufferedWriter(new FileWriter(reader.readLine()));
        while (true) {
            element = reader.readLine();
            if (element.equals("exit")) {
                file.write(element);
                break;
            } else file.write(element); file.newLine();
        }
        file.flush();
        file.close();
    }
}
