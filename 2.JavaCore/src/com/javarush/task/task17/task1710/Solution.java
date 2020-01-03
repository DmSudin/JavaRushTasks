package com.javarush.task.task17.task1710;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //ArrayList<String> arguments = new ArrayList<>(Arrays.asList(args[0].split(" ")));
        Person person;
        String name;
        Sex sex;
        Date birthDate;
        int id;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        if (args[0].equals("-c")) {
            birthDate = new SimpleDateFormat("d/MM/y", Locale.ENGLISH).parse(args[3]);
            name = args[1];
            if (args[2].equals("м")) person = Person.createMale(name, birthDate);
            else person = Person.createFemale(name, birthDate);
            allPeople.add(person);
            System.out.println(allPeople.size() - 1);
        }
        else if (args[0].equals("-u")) {
            System.out.println("before " + allPeople.size());
            person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(args[2]);
            sex = args[3].equals("м")? Sex.MALE : Sex.FEMALE;
            person.setSex(sex);
            birthDate = new SimpleDateFormat("d/MM/y", Locale.ENGLISH).parse(args[4]);
            person.setBirthDate(birthDate);
            allPeople.set(Integer.parseInt(args[1]), person);
            System.out.println("after " + allPeople.size());
        }
        else if (args[0].equals("-d")) {
            person = allPeople.get(Integer.parseInt(args[1]));
            person.setBirthDate(null);
            person.setSex(null);
            person.setName(null);

        }
        else if (args[0].equals("-i")) {
            person = allPeople.get(Integer.parseInt(args[1]));
            String sexString = person.getSex() == Sex.MALE ? "м" : "ж";
            System.out.println(person.getName() + " " + sexString + " "
                    + new SimpleDateFormat("d-MMM-y", Locale.ENGLISH).format(person.getBirthDate()));
        }
    }
}
