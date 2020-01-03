package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        ArrayList<Integer> inputed = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                inputed.add(Integer.parseInt(reader.readLine()));
            }
        } catch (NumberFormatException e) {
            for (int num: inputed) {
                System.out.println(num);
            }
        } catch (IOException e) {

        }

    }
}
