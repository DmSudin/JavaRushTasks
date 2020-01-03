package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandpaName = reader.readLine(); // Дедушка
        Cat catGrandpa = new Cat(grandpaName);
        catGrandpa.relation = "дедушка";

        String grandmaName = reader.readLine(); // Бабушка
        Cat catGrandma = new Cat(grandmaName);
        catGrandma.relation = "бабушка";

        String fatherName = reader.readLine(); // Папа
        Cat catFather = new Cat(fatherName, null, catGrandpa);
        catFather.relation = "папа";

        String motherName = reader.readLine(); // Мама
        Cat catMother = new Cat(motherName, catGrandma, null);
        catMother.relation = "мама";

        String sonName = reader.readLine(); //Сын
        Cat catSon = new Cat(sonName, catMother, catFather);
        catSon.relation = "сын";

        String daughterName = reader.readLine(); // Дочь
        Cat catDaughter = new Cat(daughterName, catMother, catFather);
        catDaughter.relation = "дочь";

        System.out.println(catGrandpa);
        System.out.println(catGrandma);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);


//        System.out.println(catMother);
//        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parentMother;
        private Cat parentFather;
        private String relation;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parentMother, Cat parentFather) {
            this.name = name;
            this.parentMother = parentMother;
            this.parentFather = parentFather;
        }

        @Override
        public String toString() {
            String parentMotherName, parentFatherName;
            if (parentMother == null) parentMotherName = "no mother"; else parentMotherName = "mother is " + " " + parentMother.name;
            if (parentFather == null) parentFatherName = "no father"; else parentFatherName = "father is " + " " + parentFather.name;
            return "The cat's name is " + name + ", " + parentMotherName + ", " + parentFatherName;
        }
    }

}
