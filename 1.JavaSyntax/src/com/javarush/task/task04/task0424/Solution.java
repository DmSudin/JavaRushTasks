package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] ints = new int[3];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(reader.readLine());
        }
        if (ints[0] == ints[1]) System.out.println(3);
        else if (ints[0] == ints[2]) System.out.println(2);
        else if (ints[1] == ints[2]) System.out.println(1);
        


    }
}
