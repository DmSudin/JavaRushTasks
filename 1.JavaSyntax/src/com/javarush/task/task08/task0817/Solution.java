package com.javarush.task.task08.task0817;
import java.util.*;

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Один", "Сто");
        map.put("Два", "Двести");
        map.put("Три", "Триста");
        map.put("Четыре", "Триста");
        map.put("Пять", "Триста");
        map.put("Шесть", "Пятьсот");
        map.put("Семь", "Десятьсот");
        map.put("Восемь", "Шестьсот");
        map.put("Девять", "Шестьсот");
        map.put("Десять", "Шестьсот");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Map<String, String> copy = new HashMap<>(map);
        List<String> values = new ArrayList<>(copy.values());
        for (Map.Entry<String, String> pair: copy.entrySet()) {
            String s = pair.getValue();
            if (Collections.frequency(values, s) > 1) removeItemFromMapByValue(map, s);

        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }

    }

    public static void main(String[] args) {
        Map<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);





    }
}
