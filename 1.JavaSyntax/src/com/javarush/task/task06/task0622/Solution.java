package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] ints = new int[5];
        for (int i = 0; i < 5; i++) {
            ints[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length-1; j++) {
                int temp;
                if (ints[j + 1] < ints[j]) {
                    temp = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }


        //напишите тут ваш код
    }
}
