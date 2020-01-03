package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        int a=0, b = 0, nod;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            a = Integer.parseInt(reader.readLine());
            b = Integer.parseInt(reader.readLine());
        } catch (IOException e) {e.printStackTrace();}

        if (a<=0 || b<=0) throw new IllegalArgumentException();

        if (a > b) nod = findNOD(a, b); else nod = findNOD(b, a);
        System.out.println(nod);
    }

    public static int findNOD(int i, int j) {
        for (int k = j; k > 0 ; k--) {if ((i % k ==0) && (j % k ==0)) return k;}
        return 1;
    }
}
