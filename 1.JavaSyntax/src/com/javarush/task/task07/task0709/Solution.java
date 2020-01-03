package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int min_length = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            String temp = reader.readLine();
            strings.add(temp);
            if (temp.length() <= min_length) min_length = temp.length();
        }
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() == min_length) System.out.println(strings.get(i));
        }
    }
}
