package com.javarush.task.task31.task3105;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileString = args[0];
        String zipString = args[1];
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipString));
        Map<String, byte[]> files = new HashMap<>();

        ZipEntry element = zipIn.getNextEntry();
        ByteArrayOutputStream baos;
        while (element != null) {
             baos = new ByteArrayOutputStream();
             int c;
            byte[] buf = new byte[8192];

            while ((c=zipIn.read(buf)) !=-1) baos.write(buf, 0, c);
            files.put(element.getName(), baos.toByteArray());
            zipIn.closeEntry();
            element = zipIn.getNextEntry();
        }
        zipIn.close();


        ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipString));
        int count = Paths.get(fileString).getNameCount()-1;

        zip.putNextEntry(new ZipEntry("new/"+Paths.get(fileString).getName(count)));
        Files.copy(Paths.get(fileString), zip);
        zip.closeEntry();
        files.forEach((str, buf)->{
            try {
                zip.putNextEntry(new ZipEntry(str));
                zip.write(buf);
                zip.closeEntry();
            } catch (IOException e) { e.printStackTrace();}

        });

        zip.close();
    }
}
