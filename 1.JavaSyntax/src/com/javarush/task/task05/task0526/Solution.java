package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man man1 = new Man("Michael",20,  "Tverskaya str");
        Man man2 = new Man("John", 30, "Yamskaya str");
        Woman woman1 = new Woman("Barbara", 25, "Varshavskaya str");
        Woman woman2 = new Woman("Susana",35, "1905 year str");
        System.out.println(man1);
        System.out.println(man2);
        System.out.println(woman1);
        System.out.println(woman2);
    }

    public static class Man {
        String name, address;
        int age;

        public Man(String name, int age, String address) {
            this.name = name;
            this.address = address;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }
    }

    public static class Woman {
        String name, address;
        int age;

        public Woman(String name, int age,String address) {
            this.name = name;
            this.address = address;
            this.age = age;
        }
        public String toString() {
            return name + " " + age + " " + address;
        }
    }
}
