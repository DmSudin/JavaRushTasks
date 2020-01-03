package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        String[] strings = Integer.toString(number).split("");
        int[] ints;
        int result = 0;
        for (String s: strings) {
            result+= Integer.parseInt(s);
        }
        return result;
    }
}