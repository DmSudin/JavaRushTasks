package com.javarush.task.task19.task1923;
import java.io.*;
import java.nio.Buffer;
import java.util.List;
import java.util.stream.Collectors;
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            List<String> file1 = reader.lines().collect(Collectors.toList());
            BufferedWriter file2 = new BufferedWriter(new FileWriter(args[1]));
//            FileWriter file2 = new FileWriter(args[1], true);
            reader.close();
            file1.forEach(s -> {
                for (String str : s.split(" ")) {
                    if ((str.matches("(\\D*\\d+\\D*)+"))
                        || (str.matches("[0-9]+[a-zA-Zа-яА-Я]+"))) {
                        try {file2.write(str + " ");} catch (IOException e) { e.printStackTrace();}
                    }
                }
            });
            file2.close();
        }
    }
}
