package com.javarush.task.task18.task1823;
import java.io.*;
import java.util.*;

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String filename = reader.readLine();
            if (filename.equals("exit")) break;
            new ReadThread(filename).start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        FileInputStream fis;

        public ReadThread(String fileName) throws FileNotFoundException {
            super();
            this.fileName = fileName;
            fis = new FileInputStream(this.fileName);
        }

        @Override
        public void run() {
            try {
                int val = findMaxByte(fis);
                synchronized (resultMap) {
                    resultMap.put(this.fileName, val);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static int findMaxByte(FileInputStream fis) throws IOException {
        int result = 0;
        FileInputStream file = fis;
        HashMap<Integer, Integer> map = new HashMap<>();
        byte[] buf = new byte[file.available()];
        while (file.available() > 0) {
            int x = file.read(buf);
        }
        file.close();
        for (byte b : buf) {
            int counter = map.getOrDefault((int) b, 0);
            map.put((int) b, ++counter);
        }
        int min = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() > min) min = pair.getValue();
        }
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() == min) result = pair.getKey();
        }
        return result;
    }
}