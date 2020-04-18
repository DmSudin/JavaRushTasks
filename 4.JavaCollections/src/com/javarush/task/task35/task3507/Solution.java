package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain()
                .getCodeSource().getLocation().getPath()
                + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
    }

    public static Set<Animal> getAllAnimals(String pathToAnimals) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Set<Animal> result = new HashSet<>();
        MyClassLoader myClassLoader = new MyClassLoader();
        File animalsDir = new File(pathToAnimals);
        ArrayList<File> fileList = new ArrayList<>(Arrays.asList(animalsDir.listFiles()));
        for (File f: fileList) {
            Class<?> clazz = myClassLoader.load(f.getAbsolutePath());
            boolean constructorChecked = false;
            for (Constructor c : clazz.getConstructors()) {
                if (c.getParameterCount()==0) constructorChecked = true;
            }
            if (constructorChecked && (Animal.class.isAssignableFrom(clazz)) )
                result.add((Animal) clazz.newInstance());
        }

        return result;
    }


    public static class MyClassLoader extends ClassLoader {

        public Class<?> load(String name) throws ClassNotFoundException {
            File file = new File(name);
            byte[] buffer = new byte[(int)file.length()];
            try {
                buffer = Files.readAllBytes(Paths.get(name));
            } catch (IOException e) {
//                e.printStackTrace();
            }
            Class<?> resultClass = defineClass(null, buffer, 0, buffer.length);
            return resultClass;

        }
    }

}
