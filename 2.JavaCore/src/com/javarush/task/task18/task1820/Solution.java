package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(fileName1));
        String inputString = reader.readLine();
        String [] numbers = inputString.split(" ");
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        for (int i = 0; i < numbers.length; i++) {
            writer.write(Math.round(Double.parseDouble(numbers[i])) + " ");
        }
        reader.close();
        writer.close();
    }
}
