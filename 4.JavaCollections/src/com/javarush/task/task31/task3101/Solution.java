package com.javarush.task.task31.task3101;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
        File workDir = new File(args[0]);
        File resultFile = new File(args[1]);
        File newResult = new File(resultFile.getParent() + "/allFilesContent.txt");

//        if (FileUtils.isExist(resultFile)) {
            FileUtils.renameFile(resultFile, newResult);
            resultFile = newResult;
//        }
        BufferedWriter out = new BufferedWriter(new FileWriter(resultFile));

        List<File> files = new ArrayList<>();
        Queue<File> fileTree = new PriorityQueue<>();
        Collections.addAll(fileTree, workDir.listFiles());
        while (!fileTree.isEmpty()) {
            File currentFile = fileTree.remove();
            if (currentFile.isDirectory()) Collections.addAll(fileTree, currentFile.listFiles());
            else files.add(currentFile);
        }
        files.removeIf(f -> f.length() > 50);

        for (File f : files) {
            StringBuilder sb = new StringBuilder();
            new BufferedReader(new FileReader(f)).lines().forEach(str -> sb.append(str));
//            sb.append("\\n");
            sb.append(System.lineSeparator());

            out.write(sb.toString());
        }
        out.close();
        }
    }
}
