package com.javarush.task.task07.task0716;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("мера");
        strings.add("лоза");
        strings.add("лира");
        strings.add("вода");
        strings.add("упор");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        ArrayList<String> result = new ArrayList<>();
        for (String s : strings) {
            if (((s.contains("р")) && (s.contains("л")))  ||  ((!s.contains("р")) && (!s.contains("л"))))
                result.add(s);
            else if ((s.contains("р")) && (!s.contains("л"))) {
            } else if (s.contains("л")) {
                result.add(s);
                result.add(s);
            }
        }
        return result;
    }
}
