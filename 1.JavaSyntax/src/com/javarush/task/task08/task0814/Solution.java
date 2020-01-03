package com.javarush.task.task08.task0814;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
    public static Set<Integer> createSet() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            set.add(i);
        }
        return set;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            if (i > 10) iterator.remove();
        }
        return set;

    }

    public static void main(String[] args) {
        Set<Integer> set = createSet();
//        Set<Integer> set =
        removeAllNumbersGreaterThan10(set);
    }
}
