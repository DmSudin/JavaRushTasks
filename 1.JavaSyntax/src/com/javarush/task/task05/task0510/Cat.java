package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    String name, address, color;
    int age, weight;

    //7
    public void initialize(String name) {
        this.name = name;
        this.age = 5;
        this.weight = 5;
        this.color = "white";

    }

    //8
    public void initialize(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = "white";
    }

    //9
    public void initialize(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 5;
        this.color = "white";
    }

    //10
    public void initialize(int weight, String color) {
        this.weight = weight;
        this.color = color;
        this.age = 5;
    }

    //11
    public void initialize(int weight, String color, String address) {
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.age = 5;
    }

    public static void main(String[] args) {

    }
}
