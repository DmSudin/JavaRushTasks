package com.javarush.task.task18.task1816;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
        int counter = 0;
        String regex = "[a-zA-Z]";
        while (file.available() > 0) {
            char element = (char) file.read();
            if (String.valueOf(element).matches(regex)) counter++;
        }
        file.close();
        System.out.println(counter);
    }
}
