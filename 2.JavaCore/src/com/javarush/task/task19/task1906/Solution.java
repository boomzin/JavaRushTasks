package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFile = bufferedReader.readLine();
        String targetFile = bufferedReader.readLine();
        bufferedReader.close();
        FileReader fileReader = new FileReader(sourceFile);
        FileWriter fileWriter = new FileWriter(targetFile);
        int count = 1;
        while (fileReader.ready()) {
            int tempByte = fileReader.read();
            if (count%2 == 0) {
                fileWriter.write(tempByte);
            }
            count++;
        }
        fileReader.close();
        fileWriter.close();
    }
}
