package com.javarush.task.task18.task1805;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        FileInputStream file = new FileInputStream(filename);
        Set<Integer> set = new HashSet<>();
        while (file.available() > 0) {
            set.add(file.read());
        }
        file.close();
        int[] arr = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            arr[i] = iterator.next();
            i++;
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < arr.length; j++) {sb.append(arr[j]).append(" ");}
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
