package com.javarush.task.task32.task3210;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/* Используем RandomAccessFile*/

public class Solution {
    public static void main(String... args) throws IOException {
        String filename = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        RandomAccessFile file = new RandomAccessFile(filename, "rw");
        file.seek(number);
        byte[] buf = new byte[text.length()];
        file.read(buf, 0, text.length());
        file.seek(file.length());
        String readed = new String(buf);
        byte[] toWrite;
        if (readed.equals(text)) {
            toWrite = "true".getBytes();
        } else toWrite = "false".getBytes();
        file.write(toWrite);
        file.close();
    }
}
