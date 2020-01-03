package com.javarush.task.task20.task2017;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        try {
        A result = (A) objectStream.readObject();
        if (result instanceof  B) result = (B) result;
        return result;
        } catch (Exception e){
            System.out.println("not A or B!");
            return null;}
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
