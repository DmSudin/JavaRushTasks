package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] ints = new int[20];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(reader.readLine());
        }
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        int middle = ints.length / 2;
        for (int i = 0; i < middle; i++) {
            arr1[i] = ints[i];
        }
        int j = 0;
        for (int i = middle; i < ints.length; i++) {
            arr2[j] = ints[i];
            System.out.println(arr2[j]);
            j++;
        }

    }
}
