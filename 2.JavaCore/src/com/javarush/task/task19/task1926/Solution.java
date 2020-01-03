package com.javarush.task.task19.task1926;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        BufferedReader file = new BufferedReader(new FileReader(filename));
        List<String> lines = file.lines().collect(Collectors.toList());
        file.close();
        lines.forEach(str->{
            StringBuilder sb = new StringBuilder(str);
            System.out.println(sb.reverse());
        });
    }
}
