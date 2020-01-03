package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] houses = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < houses.length; i++) {
            houses[i] = Integer.parseInt(reader.readLine());
        }
        int even = 0;
        int odd = 0;
        for (int i = 0; i < houses.length-1; i++) {
            if ((i % 2 ==0 ) || (i==0)) even+=houses[i]; else odd+=houses[i];
        }
        String prefix = "";
        if (odd > even) prefix = "не";
        String intro = "В домах с ";
        String outro = "четными номерами проживает больше жителей.";
        System.out.println(intro+prefix+outro);
    }
}
