package com.javarush.task.task20.task2022;
import java.io.*;

public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String filename;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.filename = fileName;
    }

    public void writeObject(String string) throws IOException {
//        System.out.println("writeObject(String string)");
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
//        System.out.println("writeObject(ObjectOutputStream out)");
        out.defaultWriteObject();
        out.writeObject(filename);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        System.out.println("readObject(ObjectInputStream in)");
        in.defaultReadObject();
        stream = new FileOutputStream(filename, true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution("d:\\result.txt");
        solution.writeObject("test string");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("d:\\solution.ser"));
        out.writeObject(solution);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("d:\\solution.ser"));
        Solution loaded = (Solution)in.readObject();
        in.close();
        loaded.writeObject("NEW test string!");
    }
}
