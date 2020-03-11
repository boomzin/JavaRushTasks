package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();
        FileInputStream fileInputStream1 = new FileInputStream(fileName1);
        byte[] bytesFromFile1 = new byte[fileInputStream1.available()];
        fileInputStream1.read(bytesFromFile1);
        fileInputStream1.close();
        FileInputStream fileInputStream2 = new FileInputStream(fileName2);
        byte[] bytesFromFile2 = new byte[fileInputStream2.available()];
        fileInputStream2.read(bytesFromFile2);
        fileInputStream2.close();
        byte[] result = new byte[bytesFromFile1.length + bytesFromFile2.length];
        System.arraycopy(bytesFromFile2, 0, result, 0, bytesFromFile2.length);
        System.arraycopy(bytesFromFile1, 0, result, bytesFromFile2.length, bytesFromFile1.length );
        FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
        fileOutputStream.write(result);
        fileInputStream2.close();
        fileOutputStream.close();
    }
}
