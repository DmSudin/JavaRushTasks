package com.javarush.task.task18.task1828;
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream file = new FileInputStream(fileName);
        byte[] buf = new byte[file.available()];
        while (file.available() > 0) {file.read(buf);}
        StringBuilder sb = new StringBuilder();
        for (byte b : buf) {sb.append((char) b);}
        LinkedList<String> strings = new LinkedList<>(Arrays.asList(sb.toString().split(System.lineSeparator())));
        file.close();
        if (args.length > 0) {
            if (args[0].equals("-u")) {
                String id = args[1];
                String productName = args[2];
                String price = args[3];
                String quantity = args[4];
                //Iterator<String> iterator = strings.iterator();
                for (int i = 0; i < strings.size(); i++) {
                    String s = strings.get(i);
                    if (s.substring(0, 8).trim().equals(id)) {
                        StringBuilder toWrite = new StringBuilder();
                        toWrite.append(String.format("%-8s%-30s%-8s%-4s", id, productName, price, quantity));
                        int index = strings.indexOf(s);
                        strings.remove(index);
                        strings.add(index, toWrite.toString());
                }
                    //                        int j = productName.length();
//                        if (j <= 30) {
//                            for (int i = 0; i <30-j ; i++) {
//                                productName = productName.concat(" ");
//                            }
//                            toWrite.append(productName);
//                        }
//                        else toWrite.append(productName.substring(0, 30)); // appended productName
//
//                        j = price.length();
//                        if (j <= 8) {
//                            for (int i = 0; i < 8 - j; i++) {
//                                price = price.concat(" ");
//                            }
//                            toWrite.append(price);
//                        } else toWrite.append(price.substring(0, 8)); // appended price
//
//                        j = quantity.length();
//                        if (j <= 4) {
//                            for (int i = 0; i < 4 - j; i++) {
//                                quantity = quantity.concat(" ");
//                            }
//                            toWrite.append(quantity);
//                        } else toWrite.append(quantity.substring(0, 4)); // appended quantity
                    }
                }

            else if (args[0].equals("-d")) {
                String id = args[1];
                Iterator<String> iterator = strings.iterator();
                while (iterator.hasNext()) {
                    String s = iterator.next();
                    if (s.substring(0, 8).trim().equals(id))
                        iterator.remove();//strings.remove(s);
                }
            }}
            FileOutputStream fileOut = new FileOutputStream(fileName);
            strings.forEach(s-> {
                try {
                    fileOut.write(s.concat(System.lineSeparator()).getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            fileOut.close();
        }
    }

