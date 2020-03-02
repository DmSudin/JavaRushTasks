package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recurse(int n) {
        boolean isSimple = true;
        if (n <=1) return;
        if (n == 2 || n == 3) {
            System.out.print(n + " ");
            return;
        }
        for (int i = 2; i < n; i++) {
            if (n % i ==0) isSimple = false;
        }
        if (isSimple) {
            System.out.print(n + " ");
            return;
        }


        // является ли множитель простым
        for (int j = 2; j < n; j++) {
            if (n % j == 0) {
                System.out.print(j + " ");
//                isSimple = false;
                recurse(n / j);
                break;
            }
        }


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse(132);
    }
}