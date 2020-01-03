package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
        int counterSpaces = 0, counterSymbols = file.available();

        while (file.available() > 0) {
            char element = (char) file.read();
            if (String.valueOf(element).equals(" ")) counterSpaces++;
            // counterSymbols++;
        }
        file.close();
        float result = (float)counterSpaces/counterSymbols*100;
        System.out.format("%.2f", result);
    }
}
