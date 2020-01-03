package com.javarush.task.task04.task0434;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        int i, j = 1;
        while (j <= 10) {
            i = 1;
            while (i <= 10) {
                System.out.print(i * j + " ");
                i++;
            }
            System.out.println();
            j++;
        }

    }
}
