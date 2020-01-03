package com.javarush.task.task32.task3211;
import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
/* Целостность информации*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true
    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
//        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
//        String obj = (String)ois.readObject();
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(byteArrayOutputStream.toByteArray());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            String hex = Integer.toHexString(0xFF & digest[i]);
            if (hex.length() ==1) sb.append('0');
            sb.append(hex);
        }
//        System.out.println(sb.toString());
//        System.out.println(HexBin.encode(digest));
        return sb.toString().equals(md5);



//        String md5This = bigInt.toString(16);
//        while (md5This.length() < 32) {
//            md5This = "0" + md5This;
//        }
//        System.out.println(md5This);
//        return md5This.equals(md5);
    }
}
