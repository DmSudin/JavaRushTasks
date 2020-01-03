package com.javarush.task.task20.task2025;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static long[] getNumbers(long N) {
        List<Long> list = new ArrayList<>();
        int j = (int) N;
        for (int i = 0; i < j; i++) {
            String strRepresent = String.valueOf(i);
            int length = strRepresent.length();
            int sumOfPows = 0;
            for (int k = 0; k < length; k++) {
                sumOfPows+=Math.pow(Integer.parseInt(String.valueOf(strRepresent.charAt(k))), length);
            }
            if (sumOfPows == i) list.add((long)i);
        }
        long[] result = new long[list.size()];
        list.forEach(l->result[list.indexOf(l)] = (long)l);
        return result;
    }

    public static void main(String[] args) {


    }
}
