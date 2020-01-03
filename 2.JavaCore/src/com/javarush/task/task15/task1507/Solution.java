package com.javarush.task.task15.task1507;
public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(short m, int n, Object value) {
        printMatrix((int)m, n, value);
    }
    public static void printMatrix(short m, short n) {}
    public static void printMatrix(byte m, short n) {}
    public static void printMatrix(double m, short n) {}
    public static void printMatrix(float m, short n) {}
    public static void printMatrix(Double m, short n) {}
    public static void printMatrix(Integer m, short n) {}
    public static void printMatrix(String m, short n) {}

}
