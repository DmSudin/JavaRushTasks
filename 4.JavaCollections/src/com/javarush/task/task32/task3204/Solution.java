package com.javarush.task.task32.task3204;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;


/* Генератор паролей*/
public class Solution {

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
        password = getPassword();
        System.out.println(password.toString());
        password = getPassword();
        System.out.println(password.toString());
        password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream result;
        StringBuilder resultString = new StringBuilder();
        Random rand = new Random();
        String chars = "abcdefghijklmnopqrstuvwxyz";
        String bigChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String[] strings = new String[3];
        strings[0] = chars;
        strings[1] = bigChars;
        strings[2] = digits;
        resultString.append(digits.charAt(rand.nextInt(10)));
        resultString.append(chars.charAt(rand.nextInt(chars.length())));
        resultString.append(String.valueOf(chars.charAt(rand.nextInt(chars.length()))).toUpperCase());
        for (int i = 0; i < 5; i++) {
            int numOfArray = rand.nextInt(3);
            resultString.append(strings[numOfArray]
                    .charAt(rand.nextInt(strings[numOfArray].length())));
        }
        List<Character> list = new ArrayList<>();
        char[] resultChar = resultString.toString().toCharArray();
        for (int i = 0; i < resultChar.length; i++) {
            Character ch = new Character(resultChar[i]);
            list.add(ch);
        }
        Collections.shuffle(list);
        result = new ByteArrayOutputStream();
        list.forEach(character -> {
            try {
                result.write(character.toString().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

//        result.write(resultString.toString().getBytes());
        return result;
    }
}