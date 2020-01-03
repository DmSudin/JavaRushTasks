package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.MIN_VALUE;
        int N = Integer.parseInt(reader.readLine());
        if (N > 0) {
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(reader.readLine());
                if (num > maximum) maximum = num;
            }
            System.out.println(maximum);
        }
    }
}
