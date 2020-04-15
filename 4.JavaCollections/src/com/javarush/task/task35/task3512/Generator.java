package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> clazz;

    public Generator(Class<T> TClass) {
        clazz = TClass;
    }

    T newInstance() throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

}
