package com.javarush.task.task18.task1821;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
        Map<Character, Integer> map = new TreeMap<>();
        while (file.available() > 0) {
            Character c = (char)file.read();
            int count = map.getOrDefault(c, 0);
            map.put(c, ++count);
        }
        file.close();
        for (Map.Entry<Character, Integer> pair: map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
