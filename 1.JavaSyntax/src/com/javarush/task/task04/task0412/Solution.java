package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader reader1 = new BufferedReader(reader);
        int n = Integer.parseInt(reader1.readLine());
        if (n>0) System.out.println(2*n);
        else if (n<0) System.out.println(n+1);
        else System.out.println(0);

    }

}