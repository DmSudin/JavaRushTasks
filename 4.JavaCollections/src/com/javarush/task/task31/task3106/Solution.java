package com.javarush.task.task31.task3106;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
//        FileOutputStream result = new FileOutputStream(args[0]);
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(args).subList(1, args.length));
        list.sort(Comparator.naturalOrder());
        List<InputStream> inputStreams = new ArrayList<>();
        list.forEach(str-> {
            try {
                inputStreams.add(new FileInputStream(str));
            } catch (FileNotFoundException e) { e.printStackTrace(); }
        });
        Enumeration<InputStream> enumeration = Collections.enumeration(inputStreams);
        ZipInputStream in = new ZipInputStream(new SequenceInputStream(enumeration));
        ZipEntry entry = in.getNextEntry();
        Files.copy(in, Paths.get(args[0]));
//        byte[] bytes = new byte[512];
//        while (entry != null) {
//            int c;
//            while ((c = in.read(bytes, 0, 512)) != -1) {
//                result.write(bytes, 0, c);
//            }
//            result.close();
//            entry = null;
//            //in.getNextEntry();
//        }
        in.close();
//        result.close();
    }
}
