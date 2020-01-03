package com.javarush.task.task03.task0325;

import java.io.*;
import java.util.*;

/* 
Финансовые ожидания
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream is = new DataInputStream(System.in);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);
        String n = reader.readLine();
        System.out.println("Я буду зарабатывать $" + n + " в час");

        System.out.println();
    }
}

