package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        int i, j;
        i = 1;
        j = 1;
        while (j < 11) {
            i = 1;
            while (i < 11) {
                System.out.print(i * j + " ");
                i++;
            }
            j++;
            System.out.println();
        }
    }
}
