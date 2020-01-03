package com.javarush.task.task19.task1909;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();
        BufferedReader in = new BufferedReader(new FileReader(filename1));
        BufferedWriter out = new BufferedWriter(new FileWriter(filename2));
        StringBuilder sb = new StringBuilder();
        while (in.ready()) {sb.append((char)in.read());}
        in.close();
        out.write(sb.toString().replaceAll("\\.", "!"));
        out.close();
    }
}
