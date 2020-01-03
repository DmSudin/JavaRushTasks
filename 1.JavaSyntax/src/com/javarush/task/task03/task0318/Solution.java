package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        //System.out.println("years: ");
        int years = Integer.parseInt(bufferedReader.readLine());
        //System.out.println("name:");
        String name = bufferedReader.readLine();
        System.out.println(name + " захватит мир через "  + years + " лет. Му-ха-ха!");
    }
}
