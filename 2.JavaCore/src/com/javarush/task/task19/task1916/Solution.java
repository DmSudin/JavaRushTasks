package com.javarush.task.task19.task1916;
import java.io.*;
import java.util.*;

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
//        if (args.length == 2) {
            Map<String, Type> stringsAndTypes = new LinkedHashMap<>();
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader1 = new BufferedReader(new FileReader(console.readLine()));
            BufferedReader reader2 = new BufferedReader(new FileReader(console.readLine()));
            List<String> strings1 = new ArrayList<>();
            List<String> strings2 = new ArrayList<>();
            reader1.lines().forEach(strings1::add);
            reader2.lines().forEach(strings2::add);
            console.close();
            reader1.close();
            reader2.close();
//            if (strings1.get(0).equals(strings2.get(0))) { // SAME
//                stringsAndTypes.put(strings1.get(0), Type.SAME);
//                strings1.remove(0);
//                strings2.remove(0); // i++; j++;
//            } else {
//                if ()
//            }
//            while (i < strings1.size()-1  && j < strings2.size()-1 ) {
//                if (strings2.get(j).equals(strings1.get(i + 1))) {
//                    stringsAndTypes.put(strings1.get(i), Type.REMOVED);
//                    stringsAndTypes.put(strings1.get(i + 1), Type.SAME);
//                    i += 2;
//                    j += 1;
//                } else {
//                    stringsAndTypes.put(strings2.get(j), Type.ADDED);
//                    stringsAndTypes.put(strings2.get(j+1), Type.SAME);
//                    i+=1;
//                    j+=2;
//                }
//            }
            while (strings1.size()>=2  && strings2.size()>=1 ) {
                if (strings1.get(0).equals(strings2.get(0))) { // SAME
                    //stringsAndTypes.put(strings1.get(0), Type.SAME);
                    lines.add(new LineItem(Type.SAME, strings1.get(0)));
                    strings1.remove(0);
                    strings2.remove(0); // i++; j++;
                } else
                if (strings2.get(0).equals(strings1.get(1))) {
//                    stringsAndTypes.put(strings1.get(0), Type.REMOVED);
                    lines.add(new LineItem(Type.REMOVED, strings1.get(0)));
//                    stringsAndTypes.put(strings1.get(1), Type.SAME);
                    lines.add(new LineItem(Type.SAME, strings1.get(1)));
                    strings1.remove(0);
                    strings1.remove(0);
                    strings2.remove(0);

                } else
                    {
//                    stringsAndTypes.put(strings2.get(0), Type.ADDED);
                        lines.add(new LineItem(Type.ADDED, strings2.get(0)));
//                    stringsAndTypes.put(strings2.get(1), Type.SAME);
                        lines.add(new LineItem(Type.SAME, strings2.get(1)));
                    strings2.remove(0);
                    strings2.remove(0);
                    strings1.remove(0);
                }
            }
            // концовка списков
            if (strings1.size() == 1) {
                if (strings2.size()==2) {
//                    stringsAndTypes.put(strings2.get(0), Type.ADDED);
                    lines.add(new LineItem(Type.ADDED, strings2.get(0)));
//                    stringsAndTypes.put(strings1.get(0), Type.SAME);
                    lines.add(new LineItem(Type.SAME, strings1.get(0)));
                } else lines.add(new LineItem(Type.REMOVED, strings1.get(0)));//stringsAndTypes.put(strings1.get(0), Type.REMOVED);
            } else if (strings1.size()==0 && strings2.size()==1){
//                stringsAndTypes.put(strings2.get(0), Type.ADDED);
                lines.add(new LineItem(Type.ADDED, strings2.get(0)));
                strings2.remove(0);

            } else System.out.println("hmmmmm");


//        }
//        for (Map.Entry<String, Type> entry: stringsAndTypes.entrySet()){
//            lines.add(new LineItem(entry.getValue(), entry.getKey()));
//        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
