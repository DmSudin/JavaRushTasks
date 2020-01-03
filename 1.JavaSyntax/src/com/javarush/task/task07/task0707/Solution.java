package com.javarush.task.task07.task0707;

import java.lang.reflect.Array;
import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> countries = new ArrayList<>();
        countries.add("Russia");
        countries.add("Belarus");
        countries.add("Moldova");
        countries.add("Spain");
        countries.add("Iran");
        System.out.println(countries.size());
        for (String s: countries             ) {
            System.out.println(s);
        }
    }
}
