package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int result;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        int year = Integer.parseInt(text);
        if (year % 400 ==0) result = 366;
        else if (year % 100 ==0) result = 365;
        else if (year % 4 ==0) result = 366;
        else result = 365;
        System.out.println("количество дней в году: " + result);

    }
}