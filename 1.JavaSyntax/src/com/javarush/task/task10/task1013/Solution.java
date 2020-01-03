package com.javarush.task.task10.task1013;
public class Solution {
    public static void main(String[] args) {}
    public static class Human {
        private String name, lastName;
        private int age, height, weight;
        private boolean sex;

        public Human(String name, String lastName, int age, int height, int weight, boolean sex) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.height = height;
            this.weight = weight;
            this.sex = sex;
        }
        public Human(String name, String lastName, int age, int height, int weight) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }
        public Human(String name, String lastName, int age, int height) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.height = height;
        }
        public Human(int age) {
            this.age = age;
        }
        public Human(String name, String lastName, int age) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
        }
        public Human(boolean sex) {
            this.sex = sex;
        }
        public Human(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }
        public Human(int height, int weight, boolean sex) {
            this.height = height;
            this.weight = weight;
            this.sex = sex;
        }
        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public Human(int age, int height) {
            this.age = age;
            this.height = height;
        }
    }
}
