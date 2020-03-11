package com.javarush.task.task34.task3411;

/* 
Ханойские башни
*/

public class Solution {
    public static void main(String[] args) {
        int numRings = 3;
        moveRing('A', 'B', 'C', numRings);
    }

    public static void moveRing(char from, char to, char temp, int numRings) {
        if (numRings > 0) {
            moveRing(from,temp, to, numRings-1);
            System.out.println("from " + from + " to " + to);
            moveRing(temp, to,from,numRings-1);
        }
    }
}