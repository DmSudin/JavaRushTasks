package com.javarush.task.task18.task1809;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1Name = reader.readLine();
        String file2Name = reader.readLine();
        reader.close();
        FileInputStream file1 = new FileInputStream(file1Name);
        FileOutputStream file2 = new FileOutputStream(file2Name);
        int file1Size = file1.available();
        byte[] buf = new byte[file1Size];
        while (file1.available() > 0) {int x = file1.read(buf);}
        for (int i = file1Size-1; i >=0; i--) {file2.write(buf[i]);}

        file1.close();
        file2.close();
    }
}
