package com.javarush.task.task15.task1514;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static Map<Double, String> labels = new HashMap<>();
    static {
        labels.put(4.557d, "String1");
        labels.put(4.555d, "String2");
        labels.put(4.535d, "String3");
        labels.put(4.255d, "String4");
        labels.put(1.555d, "String5");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
