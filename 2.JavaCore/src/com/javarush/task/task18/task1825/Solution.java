package com.javarush.task.task18.task1825;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, String> fileList = new TreeMap<>();
        boolean inCircle = true;
        String nameOfMainFile = "";
        boolean nameOfFileIsKnown = false;
        String fileName;
        while (!(fileName = reader.readLine()).equals("end")) {
            int fileNumber = Integer.parseInt(fileName.substring(fileName.indexOf("part") + 4));
            if (!nameOfFileIsKnown) {
                nameOfMainFile = fileName.substring(0, fileName.indexOf(".part"));
                nameOfFileIsKnown = true;
            }
            fileList.put(fileNumber, fileName);
        }
        FileOutputStream file = new FileOutputStream(nameOfMainFile, true);
        byte[] buf;
        for (String f : fileList.values()) {
            FileInputStream fis = new FileInputStream(f);
            buf = new byte[fis.available()];
            while (fis.available() > 0) {fis.read(buf);}
            fis.close();
            file.write(buf);
        }
        file.close();
    }
}
