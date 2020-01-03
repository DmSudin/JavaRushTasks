package com.javarush.task.task10.task1012;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я');
        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        alphabet.forEach(c -> map.put(c, 0));
        for (String element : list) {
            char[] chars = element.toCharArray();
            for (char c: chars) {
                if (map.containsKey(c)) map.put(c, map.get(c)+1);
            }
        }

        map.forEach((c, i) -> System.out.println(c + " " + i));
    }
}
