package com.javarush.task.task16.task1617;
public class Solution {
    public static volatile int numSeconds = 3;
    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
            Thread.sleep(3500);
            clock.interrupt();
    }
    public static class RacingClock extends Thread {
        public RacingClock() {start();}

        public void run() {
            String suffix;
            if (numSeconds<=3) suffix = "Марш!"; else suffix = "Прервано!";
            while (numSeconds > 0) {
                System.out.print(numSeconds + " ");
                numSeconds--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    suffix = "Прервано!";
                }
            }
            System.out.println(suffix);
            //if (!Thread.currentThread().isInterrupted()) System.out.println(suffix);

            //if (numSeconds <=3) System.out.println("Марш!");
        }
    }
}
