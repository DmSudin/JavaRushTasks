package com.javarush.task.task31.task3102;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();
        File rootFolder = new File(root);
        Queue<File> rawTree = new PriorityQueue<>(Arrays.asList(rootFolder.listFiles()));
        while (!rawTree.isEmpty()) {
            File element = rawTree.remove();
            if (element.isDirectory()) rawTree.addAll(Arrays.asList(element.listFiles()));
            else result.add(element.getAbsolutePath());
        }
        return result;

    }

    public static void main(String[] args) {
        
    }
}
