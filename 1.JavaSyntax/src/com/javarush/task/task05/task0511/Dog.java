package com.javarush.task.task05.task0511;

/* 
Создать класс Dog
*/

public class Dog {
    String name, color;
    int height;

    //5
    public void initialize(String name) {this.name = name;}

    //6
    public void initialize(String name, int height) {
        this.name = name;
        this.height = height;
    }

    //7
    public void initialize(String name, int height, String color) {
        this.name = name;
        this.height = height;
        this.color = color;
    }

    public static void main(String[] args) {

    }
}
