package com.javarush.task.task09.task0906;
public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() +
                ": " + Thread.currentThread().getStackTrace()[2].getMethodName() + ": " +s);
    }
}
