package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern patternDouble = Pattern.compile("^\\d+\\.\\d+$"); //12.1222
        Pattern patternDouble2 = Pattern.compile("^\\d+\\.$");//12.
        Pattern patternDouble3 = Pattern.compile("^\\.\\d+$"); //.12
        Pattern patternDouble4 = Pattern.compile("^\\-\\d+\\.\\d+$"); //.12

        Pattern patternNumbers = Pattern.compile("^[\\-0-9]+$");

        while (true) {
            String input = reader.readLine();
            if (input.equals("exit")) {
                break;
            } else {
                Matcher matcherDouble = patternDouble.matcher(input);
                Matcher matcherDouble2 = patternDouble2.matcher(input);
                Matcher matcherDouble3 = patternDouble3.matcher(input);
                Matcher matcherDouble4 = patternDouble4.matcher(input);
                if (matcherDouble.find() || matcherDouble2.find() || matcherDouble3.find() || matcherDouble4.find()) {
                    print(Double.parseDouble(input));
                    continue;
                }
                Matcher matcherNumbers = patternNumbers.matcher(input);
                if (matcherNumbers.find()) {
                    if ((Integer.parseInt(input) > 0) && (Integer.parseInt(input) < 128))
                        print((short) Integer.parseInt(input));
                    if ((Integer.parseInt(input) <= 0) || (Integer.parseInt(input) >= 128))
                        print(Integer.parseInt(input));
                } else  {print(input);}
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
