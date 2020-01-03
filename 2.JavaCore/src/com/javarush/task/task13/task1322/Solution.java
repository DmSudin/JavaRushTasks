package com.javarush.task.task13.task1322;

public class Solution {
    public static void main(String[] args) throws Exception {
        SimpleObject<String> stringObject = new StringObject<String>();
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    static class StringObject<String> implements SimpleObject {
        @Override
        public StringObject getInstance() {
            return this;
        }
    }



}
