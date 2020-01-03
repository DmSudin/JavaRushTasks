package com.javarush.task.task08.task0821;
import java.util.HashMap;
import java.util.Map;
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> map =new HashMap<>();
        map.put("Иванов", "Иван");
        map.put("Иванов", "Петр");
        map.put("Сидоров", "Петр");
        map.put("Михайлов", "Петр");
        map.put("Грибоедов", "Петр");
        map.put("Некрасов", "Петр");
        map.put("Салтыков", "Петр");
        map.put("Щедрин", "Петр");
        map.put("Пушкин", "Александр");
        map.put("Гоголь", "Николай");
        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
