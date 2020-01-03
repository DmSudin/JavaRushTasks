package com.javarush.task.task18.task1808;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        int file1Size, file2Size, file3Size;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        reader.close();
        FileInputStream file1 = new FileInputStream(fileName1);
        FileOutputStream file2 = new FileOutputStream(fileName2);
        FileOutputStream file3 = new FileOutputStream(fileName3);
        file1Size = file1.available();
        if (file1Size % 2 == 0) {
            file2Size = file1Size / 2;
            file3Size = file1Size / 2;
        } else {
            file2Size = file1Size / 2 + 1;
            file3Size = file1Size - file2Size;
        }
        while (file1.available() > 0) {
            byte[] buffer = new byte[file2Size];
            int bytesReaded = file1.read(buffer);
            file2.write(buffer);
            bytesReaded = file1.read(buffer);
            file3.write(buffer, 0, bytesReaded);
        }
        file1.close();
        file2.close();
        file3.close();
    }
}
