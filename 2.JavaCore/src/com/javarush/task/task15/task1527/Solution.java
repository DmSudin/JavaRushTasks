package com.javarush.task.task15.task1527;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//ttp://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
// ttp://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

       // do {
            StringBuilder sout = new StringBuilder();
            String input = reader.readLine();
            if (input.equals("exit")) return;
            String stringParameters = input.substring(input.indexOf("?"));
            String regExp = "(\\?|&)[a-zA-Z]+";
            String regExpObj = "obj=[A-Za-z0-9.]+";
            Pattern parameters = Pattern.compile(regExp);
            Matcher matcherParameters = parameters.matcher(stringParameters);
            Pattern objParameter = Pattern.compile(regExpObj);
            Matcher matcherObj = objParameter.matcher(stringParameters);

            while (matcherParameters.find()) {
                sout.append(matcherParameters.group().substring(1) + " ");
            }
            System.out.println(sout.toString().trim());

            if (matcherObj.find()) {
                String value = matcherObj.group().substring(matcherObj.group().indexOf("=")+1);
                try {
                    alert(Double.parseDouble(value));
                } catch (Exception e) { alert(value); }
            }
        //} while (true);
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
