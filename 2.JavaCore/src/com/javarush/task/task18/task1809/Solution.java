package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        byte[] value = new byte[fileInputStream.available()];
        fileInputStream.read(value);
        for (int i = value.length - 1; i >=0 ; i--) {
            fileOutputStream.write(value[i]);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
