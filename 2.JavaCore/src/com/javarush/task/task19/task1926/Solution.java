package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader readFile = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = readFile.readLine()) != null) {
            StringBuffer buffer = new StringBuffer(line);
            System.out.println(buffer.reverse());
        }
        readFile.close();
    }
}
