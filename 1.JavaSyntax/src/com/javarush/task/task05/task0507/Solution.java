package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int counter = 0;
        int sum = 0;
        float avg = 0.0f;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a;

        while ((a= Integer.parseInt(reader.readLine())) != -1) {
            counter++;
            sum+=a;
        }
        avg = (float)sum/counter;
        System.out.println(avg);
    }
}

