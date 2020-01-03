package com.javarush.task.task18.task1818;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        String filename3 = reader.readLine();
        reader.close();
        FileOutputStream out = new FileOutputStream(filename1, true);
        FileInputStream in2 = new FileInputStream(filename2);
        FileInputStream in3 = new FileInputStream(filename3);
        byte[] buf;
        while (in2.available() > 0) {
            buf = new byte[in2.available()];
            int x = in2.read(buf);
            out.write(buf, 0, x);
        }
        in2.close();
        while (in3.available() > 0) {
            buf = new byte[in3.available()];
            int x = in3.read(buf);
            out.write(buf, 0, x);
        }
        in3.close();
        out.close();
    }
}
