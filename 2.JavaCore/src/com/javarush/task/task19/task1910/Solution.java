package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputFile = bufferedReader.readLine();
        String outputFile = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader readerFile = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writerFile = new BufferedWriter(new FileWriter(outputFile));
        while (readerFile.ready()) {
            String readyLine = readerFile.readLine();
            String clearLine = readyLine.replaceAll("[^\\w\\s]", "");
            writerFile.write(clearLine);
        }
        readerFile.close();
        writerFile.close();
    }
}
