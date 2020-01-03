package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        String even = "четное ";
        String positive = "положительное ";
        String suffix = "число";
        if (a != 0) {
            if (a < 0) positive = "отрицательное ";
            if (a % 2 != 0) even = "нечетное ";
            System.out.println(positive + even + suffix);
        }  else System.out.println("ноль");

    }
}
