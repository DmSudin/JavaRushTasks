package com.javarush.task.task15.task1517;

public class Solution {
    public static int A = 0;

    static {
        int i = 5 /0;
    }

    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}
