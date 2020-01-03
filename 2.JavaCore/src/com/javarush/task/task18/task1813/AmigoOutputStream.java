package com.javarush.task.task18.task1813;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class AmigoOutputStream extends FileOutputStream  {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream component;


    public AmigoOutputStream(FileOutputStream component) throws FileNotFoundException {
        super("null");
        this.component = new FileOutputStream(fileName);
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        component.write(b, off, len);
    }

    @Override
    public void write(byte[] b) throws IOException {
        component.write(b);
    }

    @Override
    public void write(int b) throws IOException {
        component.write(b);
    }

    @Override
    public void flush() throws IOException {
        component.flush();
    }

    @Override
    public void close() throws IOException {
        component.flush();
        String text = "JavaRush © All rights reserved.";
        //int length = text.getBytes().length;
        byte[] suffix;
        suffix = text.getBytes();

        component.write(suffix);
        component.close();
    }
}
