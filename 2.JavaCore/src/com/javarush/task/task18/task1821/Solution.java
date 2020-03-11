package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        fileInputStream.close();
        int [] symbolFrequency = new int[256];
        for (int i = 0; i < bytes.length; i++) {
            symbolFrequency[bytes[i]]++;
        }
        for (int i = 0; i < symbolFrequency.length; i++) {
            if (!(symbolFrequency[i] == 0)) {
                System.out.println( (char) i + " " + symbolFrequency[i]);
            }
        }
    }
}
