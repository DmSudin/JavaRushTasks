package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        Human grandPa1 = new Human("Jack", true, 100);
        Human grandPa2 = new Human("Dmitriy", true, 105);
        Human grandMa1 = new Human("Linda", false, 100);
        Human grandMa2 = new Human("Jessica", false, 95);
        Human father = new Human("Alex", true, 50, grandPa1, grandMa1);
        Human mother = new Human("Barbara", false, 45, grandPa2, grandMa2);
        Human child1 = new Human("Tony", true, 15, father, mother);
        Human child2 = new Human("Mayson", true, 12, father, mother);
        Human child3 = new Human("Ivo", false, 9, father, mother);
        System.out.println(grandPa1);
        System.out.println(grandPa2);
        System.out.println(grandMa1);
        System.out.println(grandMa2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human {
        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        String name;
        boolean sex;
        int age;
        Human father, mother;

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}