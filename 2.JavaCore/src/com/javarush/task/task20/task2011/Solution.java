package com.javarush.task.task20.task2011;
import java.awt.*;
import java.io.*;

public class Solution {

    public static class Apartment implements Externalizable {

        private  String address;
        private int year;

        public Apartment() { super(); }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address = (String)in.readObject();
            year = in.readInt();
            in.close();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Apartment a = new Apartment("Narodnaya str, 22-65", 1977);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("d:\\aprtmnt.ser"));
        a.writeExternal(out);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("d:\\aprtmnt.ser"));
        Apartment loaded = new Apartment();
        loaded.readExternal(in);
        System.out.printf("a=%s", a.toString());
        System.out.println();
        System.out.printf("loaded=%s", loaded.toString());
    }
}
