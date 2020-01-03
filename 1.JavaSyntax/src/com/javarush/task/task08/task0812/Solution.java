package com.javarush.task.task08.task0812;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class Solution {
    static  int maxOverlaps = 1, globalMaxOverlaps = 1;
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
            if (i>0) compareElements(list.get(list.size()-1), list.get(list.size()-2));
        }
        System.out.println(globalMaxOverlaps);
    }

    public static void compareElements(int a, int b) {
        if (b==a) {
            maxOverlaps++;
            if (maxOverlaps > globalMaxOverlaps) globalMaxOverlaps = maxOverlaps;
        }
        else {
            if (globalMaxOverlaps < maxOverlaps) globalMaxOverlaps = maxOverlaps;
            maxOverlaps = 1;
        }
    }
}