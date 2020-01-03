package com.javarush.task.task16.task1618;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread test = new TestThread();
        test.start();
        test.interrupt();
    }

        public static class TestThread extends Thread{
            @Override
            public void run() {
                super.run();
            }
        }
}