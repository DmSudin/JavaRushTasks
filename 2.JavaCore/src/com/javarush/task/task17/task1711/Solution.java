package com.javarush.task.task17.task1711;
        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;
        import java.util.Locale;

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        Person person;
        int id;
        String name;
        Sex sex;
        Date birthDate;

        switch (args[0]) {

            case "-c":{    //      -c name1 sex1 bd1 name2 sex2 bd2 ...
                // -c John м 01/01/2000 Elton ж 13/11/2011
                int countOfPersons = (args.length-1) / 3;
                for (int i = 1; i <= countOfPersons*3 ; i+=3) {
                    name = args[i];
                    birthDate = new SimpleDateFormat("d/MM/y", Locale.ENGLISH).parse(args[i + 2]);
                    if (args[i+1].equals("м")) person = Person.createMale(name, birthDate);
                    else person = Person.createFemale(name, birthDate);
                    synchronized (allPeople) {
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                }
                break;
            }
            case "-u":{ //-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
                int countOfPersons = (args.length-1) / 4;
                for (int i = 1; i <=countOfPersons*4 ; i+=4) {
                    id = Integer.parseInt(args[i]);
                    name = args[i+1];
                    birthDate = new SimpleDateFormat("d/MM/y").parse(args[i + 3]);
                    if (args[i+2].equals("м")) person = Person.createMale(name, birthDate);
                    else person = Person.createFemale(name, birthDate);
                    synchronized (allPeople){allPeople.set(id, person);}
                }
                break;
            }
            case "-d":{ //-d id1 id2 id3 id4 ...
                for (int i = 1; i < args.length; i++) {
                    synchronized (allPeople) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                        allPeople.set(Integer.parseInt(args[i]), person);
                    }
                }
                break;
            }
            case "-i": { //-i id1 id2 id3 id4 ...
                for (int i = 1; i < args.length; i++) {
                    int index = Integer.parseInt(args[i]);
                    synchronized (allPeople) {
                        person = allPeople.get(index);
                        String birthDay = new SimpleDateFormat("d-MMM-y", Locale.ENGLISH)
                                .format(person.getBirthDate());
                        String sexString = person.getSex().equals(Sex.MALE)? " м " : " ж ";
                        System.out.println(person.getName() + sexString + birthDay);
                    }
                }
                break;
            }
        }

    }
}

