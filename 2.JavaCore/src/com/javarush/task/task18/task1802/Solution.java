package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filename);
        int min = fileInputStream.read();
        while (fileInputStream.available() > 0) {
            int tmp = fileInputStream.read();
            if (tmp < min) {
                min = tmp;
            }
        }
        System.out.println(min);
        fileInputStream.close();
        bufferedReader.close();
    }
}
