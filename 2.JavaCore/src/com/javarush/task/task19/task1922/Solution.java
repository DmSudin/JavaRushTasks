package com.javarush.task.task19.task1922;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
public class Solution {
    public static List<String> words = new ArrayList<String>();
    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        BufferedReader file = new BufferedReader(new FileReader(filename));
        List<String> lines = new ArrayList<>(file.lines().collect(Collectors.toList()));
        file.close();
        List<String> regExps = new ArrayList<>();
        words.forEach(str->regExps.add("\\b" + str + "\\b"));

        for (String s: lines) {
            int i = 0;
            for (String str : s.split(" ")) {
                for (String word : words) {if (str.matches(word)) i++;}
            }
            if (i==2) System.out.println(s);
        }
    }
}
