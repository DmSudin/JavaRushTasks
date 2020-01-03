package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        BufferedReader reader2 = new BufferedReader(new FileReader(filename));
        ArrayList<String> lines = new ArrayList<>(reader2.lines().collect(Collectors.toList()));
        ArrayList<String> result = new ArrayList<>();
        reader2.close();
        int max = map.keySet().stream().max(Integer::compareTo).get();
        int length = String.valueOf(max).length();
        String regexp = "\\b\\d+\\b";
        Pattern pattern = Pattern.compile(regexp);
        lines.forEach(line -> {
                    Matcher matcher = pattern.matcher(line);
                    StringBuffer sb = new StringBuffer(line);
                    int increment = 0;
                    while (matcher.find()) {
                        String toReplace = matcher.group();
                        int toFind;
                        if ((toFind = Integer.parseInt(matcher.group())) <= max) {
                            int start = matcher.start();
//                            int end = matcher.end();
                           String newString = map.get(toFind);
                            increment = String.valueOf(toFind).length();
                            sb.replace(start, start+increment, newString);
                            matcher = pattern.matcher(sb.toString());
                        }
                    }
                    result.add(sb.toString());
                }
        );
        result.forEach(System.out::println);
    }
}
