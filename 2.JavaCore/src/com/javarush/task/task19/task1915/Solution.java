package com.javarush.task.task19.task1915;
import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream console = System.out;
        String filename = reader.readLine();
        reader.close();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        FileOutputStream file = new FileOutputStream(filename);
        System.setOut(printStream);
        testString.printSomething();
        file.write(baos.toByteArray());
        file.close();
        System.setOut(console);
        System.out.println(baos.toString());


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

