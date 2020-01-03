package com.javarush.task.task16.task1630;
import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    static {
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = fileNameReader.readLine();
            secondFileName = fileNameReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {
        void setFileName(String fullFileName);
        String getFileContent();
        void join() throws InterruptedException;
        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String filename;
        String outputString = "";
        @Override
        public void setFileName(String fullFileName) {
            this.filename = fullFileName;
        }

        @Override
        public String getFileContent() {
            return outputString;
        }


        @Override
        public void run() {
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
                reader.lines().forEach(s-> sb.append(s).append(" "));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            outputString = sb.toString().trim();
        }
    }
}
