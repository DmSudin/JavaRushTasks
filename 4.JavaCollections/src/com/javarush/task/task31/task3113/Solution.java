package com.javarush.task.task31.task3113;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Solution extends SimpleFileVisitor<Path> {
    private int sumDirs, sumFiles;
    private long sumSize;

    public int getSumDirs() {
        return sumDirs;
    }

    public int getSumFiles() {
        return sumFiles;
    }

    public long getSumSize() {
        return sumSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        sumSize+=Files.size(Paths.get(file.toString()));
        sumFiles++;
        return super.visitFile(file, attrs);

    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        sumDirs++;
        return super.postVisitDirectory(dir, exc);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dirName = reader.readLine();
        reader.close();
        Path dir = Paths.get(dirName);
        if (!Files.isDirectory(dir)) {
            System.out.printf("%s - не папка", dir.toString());
            return;
        }
        Solution myVisitor = new Solution();
        Files.walkFileTree(dir, myVisitor);
        System.out.printf("Всего папок - %s", myVisitor.getSumDirs()-1);
        System.out.println();
        System.out.printf("Всего файлов - %s", myVisitor.getSumFiles());
        System.out.println();
        System.out.printf("Общий размер - %s", myVisitor.getSumSize());
        System.out.println();
    }
}


