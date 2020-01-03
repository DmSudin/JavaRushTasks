package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String even = "четное ";
        String numberOfSigns = "трехзначное ";
        String suffix = "число";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        if ((a >= 1) && (a <= 999)) {
            if (a % 2 !=0) even = "нечетное ";
            if (a<10) numberOfSigns = "однозначное ";
            if ((a>=10)&&(a<100)) numberOfSigns = "двузначное ";
            System.out.println(even + numberOfSigns + suffix);
        }
    }
}
