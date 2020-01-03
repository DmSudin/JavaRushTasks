package com.javarush.task.task18.task1803;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        FileInputStream file = new FileInputStream(filename);
        Map<Integer, Integer> pairs = new HashMap<>();
        int maxRepeats=0;
        while (file.available() > 0) {
            int k = file.read();
            if (pairs.containsKey(k)) {
                int value = pairs.get(k);
                pairs.put(k, ++value);
            } else pairs.put(k, 1);
        }

        for (int i : pairs.values()) {
            if (maxRepeats < i) maxRepeats = i;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry: pairs.entrySet()) {
            if ((int)entry.getValue() == maxRepeats) sb.append(entry.getKey() + " ");
        }
        file.close();
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
