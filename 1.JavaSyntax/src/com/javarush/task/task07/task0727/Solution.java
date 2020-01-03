package com.javarush.task.task07.task0727;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        ArrayList<String> strings = new ArrayList<String>();
//        while (true) {
//            String string = reader.readLine();
//            if (string == null || string.isEmpty()) break;
//            strings.add(string);
//        }


//        ArrayList<String> resultStrings = new ArrayList<String>();
//        for (int i = 0; i < strings.size(); i++) {
//            String string = strings.get(i);
//            resultStrings.add(string.toUpperCase());
//        }
//
//        for (int i = 0; i < resultStrings.size(); i++) {
//            System.out.println(resultStrings.get(i));
//        }

        ArrayList<String> words = new ArrayList<>();
        while (true) {
            String word = reader.readLine();
            if (word == null || word.isEmpty()) break;
            if (word.length() % 2 == 0) words.add(word + " " + word);
            else if (word.length() % 2 != 0) words.add(word + " " + word + " " + word);
        }
        for (String s : words) {
            System.out.println(s);
        }
    }
}
