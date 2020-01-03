package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();
        strings.add("мама");
        strings.add("мыла");
        strings.add("раму");
        strings.add(strings.indexOf("мама")+1,"именно");
        strings.add(strings.indexOf("мыла")+1,"именно");
        strings.add(strings.indexOf("раму")+1,"именно");
        for (String s: strings             ) {
            System.out.println(s);
        }

    }
}
