package com.javarush.task.task19.task1920;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            List<String> lines = new ArrayList<>(reader.lines().collect(Collectors.toList()));
            reader.close();
            Map<String, Double> map = new HashMap<>();
            lines.forEach(s->{
                String lastname = s.split(" ")[0];
                Double val = Double.parseDouble(s.split(" ")[1]);
                if (!map.containsKey(lastname)) map.put(lastname, val);
                else map.put(lastname, val+map.get(lastname));
            });
            Double result = map.values().stream().max(Comparator.naturalOrder()).get();
            map.forEach((s, d)-> {if (d.equals(result)) System.out.println(s);});
        }
    }
}
