package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        FileOutputStream fileOutputStream1 = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        byte [] bytes = new byte[fileInputStream.available()];
        int count = fileInputStream.read(bytes);
        if (count % 2 == 0){
            fileOutputStream.write(bytes, 0, count / 2);
            fileOutputStream1.write(bytes, count / 2, count / 2);
        } else {
            fileOutputStream.write(bytes, 0, count / 2 + 1);
            fileOutputStream1.write(bytes, count / 2 + 1, count / 2);
        }
        fileInputStream.close();
        fileOutputStream.close();
        fileOutputStream1.close();
    }
}
