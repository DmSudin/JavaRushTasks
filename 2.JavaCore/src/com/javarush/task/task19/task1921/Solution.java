package com.javarush.task.task19.task1921;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            BufferedReader file = new BufferedReader(new FileReader(args[0]));
            List<String> lines = file.lines().collect(Collectors.toList());
            file.close();
            lines.forEach(s->{
                String[] words = s.split(" ");
                int quantity = words.length;
                String year = (words[quantity - 1]);
                String month = (words[quantity - 2]);
                String day = (words[quantity - 3]);
                StringBuilder name = new StringBuilder();
                for (int i = 0; i < quantity - 3; i++) {name.append(words[i]).append(" ");}
                SimpleDateFormat format = new SimpleDateFormat("d MM y");
                Date date = new Date();
                try {date = format.parse(day + " " +  month + " " + year);}
                catch (ParseException e) {e.printStackTrace();}
                PEOPLE.add(new Person(name.toString().trim(), date));
            });
        }

    }
}
