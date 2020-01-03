package com.javarush.task.task18.task1824;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        boolean inProgress = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        while (inProgress) {
            try {
                fileName = reader.readLine();
                FileInputStream f = new FileInputStream(fileName);
                f.close();
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                inProgress = false;
            }
        }
    }
}
