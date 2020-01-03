package com.javarush.task.task10.task1015;
import java.util.ArrayList;
import java.util.Arrays;


public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String>[] result;
        result= new ArrayList[5];
        for (int i = 0; i < result.length; i++) {
            ArrayList<String> item = new ArrayList<>();
            item.add("one" + i);        item.add("two" + i);
            result[i] = item;
        }
        return result;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}