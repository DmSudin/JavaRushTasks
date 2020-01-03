package com.javarush.task.task19.task1907;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        FileReader reader1 = new FileReader(filename);
        StringBuilder sb = new StringBuilder();
        while (reader1.ready()) {sb.append((char)reader1.read());}
        reader1.close();
//        int i = sb.toString().split("(\\b|^)world(\\b|$)").length - 1;
//        System.out.println(i<=0? 0:i-1);




        Pattern pattern = Pattern.compile("(\\b|^)world(\\b|$)");
        Matcher matcher = pattern.matcher(sb.toString());
        int i = 0;
        while (matcher.find()) {i++;}
        System.out.println(i);

    }
}
