package com.javarush.task.task19.task1918;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename = reader.readLine();
            reader.close();
            String tag = args[0];
            BufferedReader file = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            ArrayList<String> strings = new ArrayList<>();
            List<String> lines = file.lines().collect(Collectors.toList());
            file.close();
            lines.forEach(line->sb.append(line));
//            lines.forEach(line->sb.append(line).append(System.lineSeparator()));
            String regexClosingTag = "</" + tag + ">"; //"</"+tag+">";
            String regexOpeningTag = "[<]"+tag + "[^>]*[>]";//"<"+tag + "[^>]*" + ">";
            ArrayList<Integer> positionsOfTags = new ArrayList<>();
            Matcher openTag = Pattern.compile(regexOpeningTag).matcher(sb.toString());
            while (openTag.find()) positionsOfTags.add(openTag.end());
            Matcher closeTag = Pattern.compile(regexClosingTag).matcher(sb.toString());
            while (closeTag.find()) positionsOfTags.add(-1* (closeTag.end()));
            positionsOfTags.sort(Comparator.comparingInt(Math::abs));
            int balance = 1;
            int readFrom = 0, readTo = 0;
            for (int i = 1; i < positionsOfTags.size(); i++) {
                if (positionsOfTags.get(i) >0) balance++; else balance--;
                if (balance == 0) {
                    readTo = Math.abs(positionsOfTags.get(i));
                    strings.add(sb.toString().substring(readFrom, readTo));
                    readFrom = Math.abs(positionsOfTags.get(i));
                }
            }
            strings.forEach(s->{
                Matcher matcher = Pattern.compile("<"+tag + ".*" + ">" + ".*" + "\\s*</" + tag + ">").matcher(s);
                while (matcher.find()) {
                    String item = matcher.group();
                    int counterClosingTags = 0;
                    // вычисляем количество пар тегов в строке (по количеству закрывающих тегов)
                    {
                        Pattern p = Pattern.compile(regexClosingTag);
                        Matcher m = p.matcher(item);
                        for (; m.find() ; counterClosingTags++) {}
                    }

                    System.out.println(clean(item, tag));
                    if (counterClosingTags > 1) {
                        String stringForIterations = item;
                        for (int i = 0; i < counterClosingTags-1; i++) {
                            stringForIterations = deleteBorderTag(stringForIterations, tag);
                            stringForIterations = clean(stringForIterations, tag);
                            System.out.println(stringForIterations);
                        }
                    }
                }
            });
        }
    }

    public static String deleteBorderTag(String src, String tag) {
        String regexClosingTag = "</" + tag + ">$";
        String regexOpeningTag = "[<]"+tag + "[^>]*[>]";
        Pattern patternopenTag = Pattern.compile(regexOpeningTag);
        Pattern patterncloseTag = Pattern.compile(regexClosingTag);
        Matcher openTag = patternopenTag.matcher(src);
        Matcher closeTag = patterncloseTag.matcher(src);
        int openTagPos = 0, openTagLen = 0, closeTagEndPos = 0, closeTagStartPops = 0;
        if (openTag.find()) {
            openTagPos = openTag.start();
            openTagLen = openTag.group().length();
        }
        if (closeTag.find()){
            closeTagEndPos = closeTag.end();
            closeTagStartPops = closeTag.start();
        }
        return src.substring(openTagPos+openTagLen, closeTagStartPops);
    }

    public static String clean(String src, String tag) {
        boolean isCleaned = false;
        String result = src;
        String openTag = "", closeTag = "";
        String regexCorrectOpeningTag = "[<]"+tag + "[^>]*[>]";
        String regexCorrectClosingTag = "</" + tag + ">$";
        String regexTestingOpeningTag = "[<][^>]*[>]";
        String regexTestingClosingTag = "</[^>]*[>]$";

        while (!isCleaned) {
            Matcher openTagMatcher = Pattern.compile(regexTestingOpeningTag).matcher(result);
            Matcher closeTagMatcher = Pattern.compile(regexTestingClosingTag).matcher(result);
            if (openTagMatcher.find()) openTag = openTagMatcher.group();
            if (closeTagMatcher.find()) closeTag = closeTagMatcher.group();
            Matcher correctOpenTagMatcher = Pattern.compile(regexCorrectOpeningTag).matcher(openTag);
            Matcher correctCloseTagMatcher = Pattern.compile(regexCorrectClosingTag).matcher(closeTag);
            if (correctOpenTagMatcher.find() && correctCloseTagMatcher.find()) {
                isCleaned = true;
                break;
            }
            else {
                result = result.substring(openTagMatcher.end(), closeTagMatcher.start());
            }
        }
        return result;

    }
}
