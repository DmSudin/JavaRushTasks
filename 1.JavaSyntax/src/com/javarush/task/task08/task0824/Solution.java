package com.javarush.task.task08.task0824;
import java.util.ArrayList;
import java.util.List;
public class Solution {
    public static void main(String[] args) {
        Human child1 = new Human(); child1.name = "Paul"; child1.sex = true; child1.age = 10; child1.children = new ArrayList<>();
        Human child2 = new Human(); child2.name = "Chris"; child2.sex = true; child2.age = 9;child2.children = new ArrayList<>();
        Human child3 = new Human(); child3.name = "Jenifer"; child3.sex = false; child3.age = 5;child3.children = new ArrayList<>();
        Human father = new Human(); father.name = "Roman"; father.sex = true; father.age = 33;
        father.children = new ArrayList<>();

        father.children.add(child1);
        father.children.add(child2);
        father.children.add(child3);
        Human mother = new Human(); mother.name = "Karina"; mother.sex = false; mother.age = 23;
        mother.children = new ArrayList<>();
        mother.children.add(child1); mother.children.add(child2); mother.children.add(child3);
        Human grandMa1 = new Human(); grandMa1.name = "Olya"; grandMa1.sex = false; grandMa1.age = 55;
        grandMa1.children = new ArrayList<>();
        grandMa1.children.add(father);
        Human grandMa2 = new Human(); grandMa2.name = "Masha"; grandMa2.sex = false; grandMa2.age = 57;
        grandMa2.children = new ArrayList<>();
        grandMa2.children.add(mother);
        Human grandPa1 = new Human(); grandPa1.name = "Pasha"; grandPa1.sex = true; grandPa1.age = 57;
        grandPa1.children = new ArrayList<>();
        grandPa1.children.add(father);
        Human grandPa2 = new Human(); grandPa2.name = "Igor"; grandPa2.sex = true; grandPa2.age = 60;
        grandPa2.children = new ArrayList<>();
        grandPa2.children.add(mother);
        System.out.println(grandPa1.toString());
        System.out.println(grandPa2.toString());
        System.out.println(grandMa1.toString());
        System.out.println(grandMa2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());

    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
