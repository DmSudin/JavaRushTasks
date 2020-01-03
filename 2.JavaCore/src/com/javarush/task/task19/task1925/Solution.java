package com.javarush.task.task19.task1925;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
            List<String> lines = file1.lines().collect(Collectors.toList());
            file1.close();
            ArrayList<String> words = new ArrayList<>();
            for (String s : lines) {words.addAll(Arrays.stream(s.split(" ")).collect(Collectors.toList()));}
            BufferedWriter file2 = new BufferedWriter(new FileWriter(args[1]));
            boolean needToPunct = false;
            for (int i = 0; i < words.size(); i++) {
                if (words.get(i).length() > 6) {
                    if (needToPunct) file2.write(",");
                    file2.write(words.get(i));
                    needToPunct = true;
                }
            }
            file2.close();
        }
    }
}
