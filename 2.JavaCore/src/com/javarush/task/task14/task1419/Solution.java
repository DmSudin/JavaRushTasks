package com.javarush.task.task14.task1419;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {
        try {float i = 1 / 0; } catch (Exception e) {exceptions.add(e); }
        try {InputStream is = new FileInputStream("C:\bla.txt");} catch (FileNotFoundException e) {exceptions.add(e);}
        int[] arr = new int[5];
        char c;
        int zero = 0; int minus = -2;
        Object object = null;
        String filename = "D:\\file.docx";
        try {int elem = arr[-2];}  catch (IndexOutOfBoundsException e) {exceptions.add(e);} //1
        try {int res = 5 / zero;} catch (ArithmeticException e) {exceptions.add(e);}
        try {Integer.parseInt("bla");} catch (NumberFormatException e) {exceptions.add(e);} //3
        try {int[] arr2 = new int[minus];} catch (NegativeArraySizeException e) {exceptions.add(e);}
        try {System.out.println(object);} catch (NullPointerException e) {exceptions.add(e);} //5
        try {filename = (String)object;} catch (ClassCastException e) {exceptions.add(e);} //6
        try {throw new UnsupportedOperationException();} catch (UnsupportedOperationException e) {exceptions.add(e);}
        try {throw new StringIndexOutOfBoundsException();} catch (StringIndexOutOfBoundsException e) {exceptions.add(e);}
        try {throw new SecurityException();} catch (SecurityException e) {exceptions.add(e);}
        try {throw new IOException();} catch (IOException e) {exceptions.add(e);}

    }
}
