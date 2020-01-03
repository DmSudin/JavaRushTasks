package com.javarush.task.task20.task2002;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            User user1 = new User();
            user1.setCountry(User.Country.UKRAINE);
            user1.setFirstName("Sashko");
            user1.setLastName("Leschenko");
            user1.setMale(true);
            //user1.setBirthDate(new SimpleDateFormat("dd-MM-y").parse("15-04-1981"));
            user1.setBirthDate(new Date(System.currentTimeMillis()));
            User user2 = new User();
            user2.setCountry(User.Country.RUSSIA);
            user2.setFirstName("Ekaterina");
            user2.setLastName("Kuznecova");
            user2.setMale(false);
            user2.setBirthDate(new SimpleDateFormat("dd-MM-y").parse("10-10-2011"));
            javaRush.users = new ArrayList<>();
            javaRush.users.add(user1);
            javaRush.users.add(user2);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println("javarush == loaded: " + javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception{
            for (User u : users) {
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(u.getBirthDate());
//                String birthdayString = (calendar.get(Calendar.DAY_OF_MONTH)) + "-"+
//                        (calendar.get(Calendar.MONTH)+1) + "-"+
//                        calendar.get(Calendar.YEAR);

                String genderString = u.isMale()? "man" : "woman";
                String toWrite = u.getFirstName().concat(System.lineSeparator())
                        .concat(u.getLastName().concat(System.lineSeparator()
                        .concat(genderString).concat(System.lineSeparator())
                        .concat(String.valueOf(u.getBirthDate().getTime())).concat(System.lineSeparator())
                        .concat(u.getCountry().getDisplayName()))).concat(System.lineSeparator());
                outputStream.write(toWrite.getBytes());
                outputStream.flush();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            while (in.ready()) {
                String firstName = in.readLine();
                String lastName = in.readLine();
                String genderString = in.readLine();
                String birthDayString = in.readLine();
                Date birthDate = new Date(Long.valueOf(birthDayString));
                String country = in.readLine();
                User user = new User();
                user.setFirstName(firstName);
                user.setLastName(lastName);
                if (genderString.equals("man")) user.setMale(true); else user.setMale(false);
                //user.setBirthDate(new SimpleDateFormat("dd-MM-y").parse(birthDayString));
                user.setBirthDate(birthDate);
                if (country.equals("Ukraine")) user.setCountry(User.Country.UKRAINE);
                else if (country.equals("Russia")) user.setCountry(User.Country.RUSSIA);
                else user.setCountry(User.Country.OTHER);
                users.add(user);
            }
            in.close();
            System.out.println();
            System.out.println();
            System.out.println();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
