package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    int top, left, width, height;

    public Rectangle(int top, int left, int widht, int height) {
        this.top = top;
        this.left = left;
        this.width = widht;
        this.height = height;
    }

    public Rectangle(int top, int left) {
        this.top = top;
        this.left = left;
        this.width = 0;
        this.height = 0;
    }

    public Rectangle(int top, int left, int widht) {
        this.top = top;
        this.left = left;
        this.width = widht;
        this.height = widht;
    }

    public Rectangle(Rectangle another) {
        this.left = another.left;
        this.top = another.top;
        this.width = another.width;
        this.height = another.height;
    }

    public static void main(String[] args) {

    }
}
