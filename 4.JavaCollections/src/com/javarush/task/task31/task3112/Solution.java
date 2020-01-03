package com.javarush.task.task31.task3112;
import java.io.IOException;
import java.net.URL;
import java.nio.file.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        Files.createDirectories(downloadDirectory);
        String dstFileName = url.getFile().split("/")[url.getFile().split("/").length-1];
//        Path tempFile = Files.createTempFile("JR", "-temp");
        Path tempFile = Files.createTempFile(dstFileName, ".JRtemp");
        Files.copy(url.openStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);
        Path dstFile = Paths.get(downloadDirectory + "/" + dstFileName);
        Files.move(tempFile, dstFile);
        return dstFile;
    }
}
