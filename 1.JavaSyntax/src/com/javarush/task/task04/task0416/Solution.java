package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double t = Double.parseDouble(reader.readLine());
        double res = t % 5;
        if (res < 3.0) System.out.println("зелёный");
        else if ((res >=3.0) && (res < 4.0)) System.out.println("жёлтый");
        else System.out.println("красный");


    }
}