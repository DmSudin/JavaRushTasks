package com.javarush.task.task19.task1906;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();
        FileReader reader1 = new FileReader(filename1);
        FileWriter writer = new FileWriter(filename2);

        int i =0;
        while (reader1.ready()) {
            int ch = reader1.read();
            i++;
            if (i % 2 ==0) writer.write(ch);
        }
        reader1.close();
        writer.close();

    }
}
