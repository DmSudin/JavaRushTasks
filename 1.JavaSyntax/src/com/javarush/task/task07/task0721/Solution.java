package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[20];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.MIN_VALUE, minimum = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
            if (arr[i] > maximum) maximum = arr[i];
            if (arr[i] < minimum) minimum = arr[i];
        }
        System.out.print(maximum + " " + minimum);
    }
}
