package com.javarush.task.task19.task1914;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
        testString.printSomething();
        String example = baos.toString();
        Matcher matcher = Pattern.compile("[^0-9= ]").matcher(example);
        String operation = null;
        if (matcher.find()) operation = matcher.group();
        int oper1 = Integer.parseInt(example.substring(0, example.indexOf(operation)).trim());
        int oper2 = Integer.parseInt(example.substring(example.indexOf(operation)+1, example.indexOf("="))
                .trim());
        int result = 0;
        switch (operation) {
            case "+":{
                result = oper1 + oper2;
                break;
            }
            case "-":{
                result = oper1 - oper2;
                break;
            }
            case "*":{
                result = oper1 * oper2;
                break;
            }
        }
        System.setOut(console);
        int l = String.valueOf(oper1).length() + String.valueOf(oper2).length() + 6;
        System.out.println(example.substring(0, l) + String.valueOf(result));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

