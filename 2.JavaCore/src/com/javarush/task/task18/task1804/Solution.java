package com.javarush.task.task18.task1804;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        FileInputStream file = new FileInputStream(filename);
        Map<Integer, Integer>pairs = new HashMap<>();
        int minRepeats = Integer.MAX_VALUE;
        while (file.available() > 0) {
            int key = file.read();
            if (pairs.containsKey(key)) {
                int value = pairs.get(key);
                pairs.put(key, ++value);
            } else pairs.put(key,   1);
        }
        file.close();
        for (int i: pairs.values()) {if (i < minRepeats) minRepeats = i;}
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry: pairs.entrySet()) {
            if (entry.getValue() == minRepeats) sb.append(entry.getKey()).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
