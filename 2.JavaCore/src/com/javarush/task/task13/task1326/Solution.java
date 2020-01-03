package com.javarush.task.task13.task1326;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        ArrayList<Integer> integers = new ArrayList<>();
        fileReader.lines().forEach(s -> integers.add((Integer.parseInt(s))));
        fileReader.close();
        Collections.sort(integers);
        for (int i: integers  ) {  if (i % 2 == 0) System.out.println(i); }
    }
}
