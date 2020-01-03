package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    public Circle() {
        this.x = 5.0;
        this.y = 5.0d;
        this.radius = 5;
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public Circle(double x, double y) {
        this.x = x;
        this.y = y;
        this.radius = 5;
    }

    public Circle(int x) {
        this(x, 5);
    }

    public Circle(Circle another) {
        this(another.x, another.y, another.radius);
    }

    public static void main(String[] args) {

    }
}