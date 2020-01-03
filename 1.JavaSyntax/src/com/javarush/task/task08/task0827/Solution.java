package com.javarush.task.task08.task0827;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date data = new Date(date);
        int days = data.getDate();
        int month = data.getMonth();
        int year = data.getYear();
        Calendar calendar = new GregorianCalendar(year, month, days);
        if (calendar.get(Calendar.DAY_OF_YEAR) % 2 ==0) return false;
        return true;
    }
}
