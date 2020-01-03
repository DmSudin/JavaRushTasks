package com.javarush.task.task19.task1904;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
public class Solution {

    public static void main(String[] args) {}

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;
        public PersonScannerAdapter(Scanner scanner) {
            this.fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException{
            Person person;
            String str = "";
            Date date = null;
            if (fileScanner.hasNextLine())
                str = fileScanner.nextLine();
            String[] data = str.split(" ");
            try {
                date = new SimpleDateFormat("d/MM/y", Locale.ENGLISH).parse(data[3].concat("/").concat(data[4]).concat("/").concat(data[5]));
            } catch (ParseException e) {e.printStackTrace();}
            person = new Person(data[1], data[2], data[0], date);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();

        }
    }
}
