package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader;
        if (args.length ==1) {
            reader = new BufferedReader(new FileReader(args[0]));
            Map<String, Double> persons = new TreeMap<>();
            List<String> lines = reader.lines().collect(Collectors.toList());
            reader.close();
            for (String s :lines) {
                String lastName = s.split(" ")[0];
                Double sum = Double.parseDouble(s.split(" ")[1]);
                if (persons.containsKey(lastName)) {persons.put(lastName, sum+persons.get(lastName));}
                else persons.put(lastName, sum);
            }
            persons.forEach((k, v)-> System.out.println(k + " " + v));
        }
    }
}
