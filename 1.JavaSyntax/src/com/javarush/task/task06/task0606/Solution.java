package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        int numberOfNums = text.length();
        for (int i = 0; i < numberOfNums; i++) {
            int next = Integer.parseInt(text.substring(i, i+1));
            if (next % 2 ==0) Solution.even++; else  Solution.odd++;
        }
        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
