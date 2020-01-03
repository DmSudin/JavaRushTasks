package com.javarush.task.task15.task1525;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Statics.FILE_NAME));
            reader.lines().forEach(s -> lines.add(s));

        } catch (FileNotFoundException e) { e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
