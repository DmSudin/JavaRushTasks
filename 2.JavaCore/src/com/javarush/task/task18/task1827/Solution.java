package com.javarush.task.task18.task1827;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int maxID = Integer.MIN_VALUE;
        reader.close();
        if (args.length != 0) {
            if (args[0].equals("-c")) {
                FileInputStream in = new FileInputStream(fileName);
                int max = Integer.MIN_VALUE;
                ArrayList<Character> chars = new ArrayList<>();
                while (in.available() > 0) {
                    chars.add((char) in.read());
                }
                StringBuilder sb = new StringBuilder();
                chars.forEach(sb::append);
                String str = sb.toString();
                List<String> strings = Arrays.asList(str.split("\\r\\n"));
                ArrayList<Integer> ints = new ArrayList<>();
                for (String s : strings) {
                    String tmp = s.substring(0, 8).trim();
                    ints.add(Integer.parseInt(tmp));
                }
                ints.sort(Comparator.naturalOrder());
                maxID = ints.get(ints.size() - 1) + 1;
                StringBuilder toWrite = new StringBuilder();
                String idString = String.valueOf(maxID);
                int j = 8 - idString.length();

                for (int i = 0; i < j; i++) {
                    idString = idString.concat(" ");
                }

                String productName = args[1];
                if (productName.length() > 30) productName = productName.substring(0, 30);
                j = 30 - productName.length();
                for (int i = 0; i < j; i++) {
                    productName = productName.concat(" ");
                }

                String price = args[2];
                j = 8 - price.length();
                if (price.length() > 8) price = price.substring(0, 8);
                for (int i = 0; i < j; i++) {
                    price = price.concat(" ");
                }

                String quantity = args[3];
                j = 4 - quantity.length();
                if (quantity.length() > 4) quantity = quantity.substring(0, 4);
                for (int i = 0; i < j; i++) {
                    quantity = quantity.concat(" ");
                }

                toWrite.append(System.lineSeparator());
                toWrite.append(idString);
                toWrite.append(productName);
                toWrite.append(price);
                toWrite.append(quantity);
                toWrite.append(System.lineSeparator());
                FileOutputStream out = new FileOutputStream(fileName, true);
                out.write(toWrite.toString().getBytes());
                out.close();
                in.close();
            }
        }

    }
}


