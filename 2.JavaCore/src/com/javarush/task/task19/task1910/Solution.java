package com.javarush.task.task19.task1910;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();
        BufferedReader in = new BufferedReader(new FileReader(filename1));
        BufferedWriter out = new BufferedWriter(new FileWriter(filename2));
        ArrayList<String> lines = in.lines().collect(Collectors.toCollection(ArrayList::new));
//        Pattern pattern = Pattern.compile("\\W|[^ ]|\\n");
        Pattern pattern = Pattern.compile("\\p{Punct}|\\n}");
        Matcher matcher;
        for (String s: lines) {
            matcher = pattern.matcher(s);
            while (matcher.find()) {s = s.replace(matcher.group(), "");}
            out.write(s);
        }
        in.close();
        out.close();
    }
}
