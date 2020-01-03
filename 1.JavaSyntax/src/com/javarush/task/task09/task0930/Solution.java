package com.javarush.task.task09.task0930;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);

        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                for (int k = j+1; k < array.length; k++) {
                    if (isNumber(array[j])) {
                        if (isNumber(array[k])) {
                            if (Integer.parseInt(array[k]) > Integer.parseInt(array[j])) {
                                String temp = array[j];
                                array[j] = array[k];
                                array[k] = temp;
                            }
                        }
                    } else if (!isNumber(array[j]) && !isNumber(array[k])) { // очередной элемент - это слово


                        if (isGreaterThan(array[j], array[k])) {

                            String temp = array[j]; // меняем местами array J & array K
                            array[j] = array[k];
                            array[k] = temp;
                        }
                    }
                }
            }
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
