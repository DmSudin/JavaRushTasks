package com.javarush.task.task32.task3201;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
/*Запись в существующий файл*/
public class Solution {
    public static void main(String... args) throws IOException {
        String filename = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        byte[] buffer = text.getBytes();
        RandomAccessFile raf = new RandomAccessFile(filename, "rw");
//        raf.seek(pos);
        if (number <= raf.length()){
            raf.seek(number);
            raf.write(text.getBytes());
        }
        else{
            raf.seek(raf.length());
//            raf.skipBytes((int)raf.length());
            raf.write(text.getBytes());
        }
        raf.close();
    }
}
