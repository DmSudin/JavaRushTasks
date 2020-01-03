package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> result = new ArrayList<>();
        int[] ints7 = new int[7];
        for (int i = 0; i < ints7.length; i++) {
            ints7[i] = i*3+4;
        }
        int[] ints5 =  new int[5];
        int[] ints2 =  new int[2];
        int[] ints4 =  new int[4];
        int[] ints0 = new int[0];
        System.arraycopy(ints7, 0, ints5, 0, 5);
        System.arraycopy(ints7, 0, ints2, 0, 2);
        System.arraycopy(ints7, 0, ints4, 0, 4);
        result.add(ints5);
        result.add(ints2);
        result.add(ints4);
        result.add(ints7);
        result.add(ints0);
        return result;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
