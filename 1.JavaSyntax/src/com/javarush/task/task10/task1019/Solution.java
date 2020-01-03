package com.javarush.task.task10.task1019;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s1 = reader.readLine();
            if ((s1.equals(""))) break;
            String name = reader.readLine();
            int id = Integer.parseInt(s1);
            map.put(name, id);
        }
        map.forEach((s, i) -> System.out.println(i + " " + s));
    }
}
