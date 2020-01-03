package com.javarush.task.task31.task3111;
import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName, partOfContent;
    private int minSize, maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        if (isSizeCorrect(minSize, maxSize, content.length)
                && isNameCorrect(file.getFileName().toString(), partOfName)
                && isContentCorrect(content, partOfContent))
            foundFiles.add(file);
        return super.visitFile(file, attrs);
    }

    private boolean isSizeCorrect(int minSize, int maxSize, int fileSize) {
        if (
                (minSize > 0 && maxSize > 0 && maxSize > minSize
                && fileSize>=minSize && fileSize<=maxSize)         // both sizes are referred
             || (minSize == 0 && maxSize >0 && fileSize < maxSize)  // only maxSize is referred
             || (maxSize == 0 && minSize >0 && fileSize > minSize) // only minSize is referred
             || (minSize==0 && maxSize==0)                          // neither minSize nor maxSize is referred
        )
            return true;
        return false;
    }
    private boolean isNameCorrect(String filename, String expression) {
        if (null == expression) return true;
        if (filename.contains(expression)) return true;
        return false;
    }
    private boolean isContentCorrect(byte[] content, String partOfContent) {
        if (null== partOfContent) return true;
        ByteArrayInputStream bais = new ByteArrayInputStream(content);
        BufferedReader reader = new BufferedReader(new InputStreamReader(bais));
        ArrayList<String> lines = new ArrayList<>(reader.lines().collect(Collectors.toList()));
        for (String line : lines) { if (line.contains(partOfContent)) return true;}
        return false;
    }

}
