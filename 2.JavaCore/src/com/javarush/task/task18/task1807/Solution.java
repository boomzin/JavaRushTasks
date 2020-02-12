package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int count = 0;
        byte [] value = new byte[fileInputStream.available()];
        fileInputStream.read(value);
        fileInputStream.close();
        for (int i = 0; i < value.length; i++) {
            if (value[i] == 44) {
                count++;
            }
        }
        System.out.println(count);
    }
}
