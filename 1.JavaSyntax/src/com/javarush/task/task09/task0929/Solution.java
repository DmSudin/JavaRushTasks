package com.javarush.task.task09.task0929;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String srcFileName, dstFileName;
        InputStream fileInputStream;
        srcFileName = reader.readLine();
        try {
            fileInputStream = getInputStream(srcFileName);
        } catch (IOException e) {
            System.out.println("Файл не существует.");
            srcFileName = reader.readLine();
        }
        fileInputStream = getInputStream(srcFileName);
        dstFileName = reader.readLine();
        OutputStream fileOutputStream = getOutputStream(dstFileName);

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static InputStream getInputStream(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }

    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }
}

