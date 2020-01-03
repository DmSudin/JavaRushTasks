package com.javarush.task.task07.task0713;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> listMain = new ArrayList<>();
        ArrayList<Integer> listThree = new ArrayList<>();
        ArrayList<Integer> listTwo = new ArrayList<>();
        ArrayList<Integer> listOther = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            int element = Integer.parseInt(reader.readLine());
            listMain.add(element);
            if (element % 3 ==0) listThree.add(element);
            if (element % 2 ==0) listTwo.add(element);
            if ((element % 3 !=0) && (element % 2 !=0)) listOther.add(element);
        }
        printList(listThree);
        printList(listTwo);
        printList(listOther);
    }

    public static void printList(ArrayList<Integer> list) {
        for (int i: list) {
            System.out.println(i);
        }
    }
}
