package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        StringBuilder builder = new StringBuilder(string);
        if (Character.isAlphabetic(string.codePointAt(0))) builder.setCharAt(0, Character.toUpperCase(string.charAt(0)));
        for (int i = 1; i < string.length(); i++) {
            if (Character.isAlphabetic(string.charAt(i)) && Character.isSpaceChar(string.charAt(i-1)))
                builder.setCharAt(i, Character.toUpperCase(string.charAt(i)));
        }
        System.out.println(builder);
    }
}
