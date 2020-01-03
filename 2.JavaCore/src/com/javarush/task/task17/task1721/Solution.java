package com.javarush.task.task17.task1721;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        allLines.addAll(fileReader.lines().collect(Collectors.toList()));
        fileReader = new BufferedReader(new FileReader(fileName2));
        forRemoveLines.addAll(fileReader.lines().collect(Collectors.toList()));
        Solution solution = new Solution();
        try {solution.joinData();}
        catch (CorruptedDataException e) {e.printStackTrace();}
        reader.close();
        fileReader.close();
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) allLines.removeAll(forRemoveLines);
            else {
                allLines.removeAll(allLines);
                throw new CorruptedDataException();
            }
        }
    }

