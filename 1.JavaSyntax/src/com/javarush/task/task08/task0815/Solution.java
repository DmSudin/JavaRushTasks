package com.javarush.task.task08.task0815;

import java.util.*;


public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Один", "Сто");
        map.put("Два", "Двести");
        map.put("Три", "Триста");
        map.put("Четыре", "Триста");
        map.put("Пять", "Четыреста");
        map.put("Шесть", "Пятьсот");
        map.put("Семь", "Пятьсот");
        map.put("Восемь", "Пятьсот");
        map.put("Девять", "Шестьсот");
        map.put("Десять", "Семьсот");
        return map;

    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
       return Collections.frequency(map.values(), name);
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int result = 0;
        for (String s : map.keySet()) {
            if (s.equals(lastName)) result++;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
