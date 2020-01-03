package com.javarush.task.task08.task0818;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Ivanov", 1000);
        map.put("Petrov", 9000);
        map.put("Sidorov", 450);
        map.put("Kuznecov", 300);
        map.put("Kozlov", 600);
        map.put("Baranov", 6000);
        map.put("Komarov", 400);
        map.put("Meshkov", 800);
        map.put("Nekrasov", 1000);
        map.put("Ermolenko", 2000);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> pair = iterator.next();
            if (pair.getValue() < 500) iterator.remove();
        }
    }

    public static void main(String[] args) {

    }
}