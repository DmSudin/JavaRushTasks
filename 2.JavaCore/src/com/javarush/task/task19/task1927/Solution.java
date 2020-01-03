package com.javarush.task.task19.task1927;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream my = new PrintStream(baos);
        System.setOut(my);
        testString.printSomething();
        System.setOut(console);
        String[] strings = baos.toString().split(System.lineSeparator());
        int counter = 0;
        for (int i = 0; i < strings.length; i++) {
            counter++;
            System.out.println(strings[i]);
            if (counter % 2 ==0) System.out.println("JavaRush - курсы Java онлайн");
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
