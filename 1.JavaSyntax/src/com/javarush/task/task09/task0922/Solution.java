package com.javarush.task.task09.task0922;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class Solution {

    public static void main(String[] args) throws Exception {
        Date date;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        SimpleDateFormat dateFormatIn = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        SimpleDateFormat dateFormatOut = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        date = dateFormatIn.parse(text);
        String sout = dateFormatOut.format(date);
        System.out.println(sout.toUpperCase());
    }
}
