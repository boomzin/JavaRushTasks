package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputFile = bufferedReader.readLine();
        String outputFile = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFile));
        while (fileReader.ready()) {
            String readyString = fileReader.readLine();
            String replacedString = readyString.replace(".", "!");
            fileWriter.write(replacedString + "\n");
        }
        fileReader.close();
        fileWriter.close();
    }
}
