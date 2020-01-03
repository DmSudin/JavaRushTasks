package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();
        BufferedReader input = new BufferedReader(new FileReader(filename1));
        BufferedWriter output = new BufferedWriter(new FileWriter(filename2));
        Pattern pattern = Pattern.compile("(^|\\b)\\d+(\\b|$)");
        StringBuilder sb = new StringBuilder();
        while (input.ready()) { sb.append((char)input.read());    }
            Matcher matcher = pattern.matcher(sb.toString());
        while (matcher.find()) output.write(matcher.group() + " ");
        input.close();
        output.close();



    }
}
