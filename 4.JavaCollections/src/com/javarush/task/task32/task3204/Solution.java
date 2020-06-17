package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        ByteArrayOutputStream password = getPassword();
//        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws NoSuchAlgorithmException {
        System.out.println(Integer.valueOf(Character.valueOf('a')));
//        List<Character> list = new ArrayList<>({'A'..'Z'});
//        char[] chars = new char[]{'A'-'Z'};
        byte[] bytes = new byte[] {1, 2, 3, 4, 5, 6};
        MessageDigest messageDigest = MessageDigest.getInstance("md5");
        byte[] pass = messageDigest.digest(bytes);
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder = stringBuilder.append(Character.valueOf(b));
        }
        stringBuilder.append("a");
        System.out.println(Arrays.toString(pass));
        System.out.println(stringBuilder.toString());
        return null;
    }
}