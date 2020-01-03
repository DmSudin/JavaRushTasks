package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        int minLength = Integer.MAX_VALUE;
        int maxLength = -1;
        for (String s :list) {
            if (s.length() < minLength) minLength = s.length();
            if (s.length() > maxLength) maxLength = s.length();
        }
        for (String s : list) {
            if ((s.length() == minLength) || (s.length() == maxLength)) {
            System.out.println(s);
            break;
            }
        }
    }
}
