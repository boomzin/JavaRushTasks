package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filename);
        int max = 0;
        while (fileInputStream.available() > 0) {
            int tmp = fileInputStream.read();
            if (tmp > max) {
                max = tmp;
            }
        }
        System.out.println(max);
        bufferedReader.close();
        fileInputStream.close();
    }
}
