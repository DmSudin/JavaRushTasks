package com.javarush.task.task20.task2003;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        load(new FileInputStream(filename));
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        prop.putAll(properties);
        prop.store(outputStream, "");


    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        prop.forEach((k, v)->properties.put(k.toString(), v.toString()));
    }

    public static void main(String[] args) {
    }
}
