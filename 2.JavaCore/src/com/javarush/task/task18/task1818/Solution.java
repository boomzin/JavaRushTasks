package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        FileOutputStream fileOutputStream = new FileOutputStream(fileName1);

        String fileName2 = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName2);
        byte[] bytesArray = new byte[fileInputStream.available()];
        fileInputStream.read(bytesArray);
        fileOutputStream.write(bytesArray);

        fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        fileOutputStream = new FileOutputStream(fileName1, true);
        fileInputStream.close();
        fileInputStream = new FileInputStream(fileName2);
        bytesArray = new byte[fileInputStream.available()];
        fileInputStream.read(bytesArray);
        fileOutputStream.write(bytesArray);
        fileInputStream.close();
        fileOutputStream.close();
    }
}
