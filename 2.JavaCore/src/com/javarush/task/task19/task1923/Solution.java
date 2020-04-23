package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        String sourceFile = args[0];
        String targetFile = args[1];
        BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetFile));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            String [] splitLine = line.split(" ");
            List<String> clearLine = new ArrayList<>();
            for (int i = 0; i < splitLine.length; i++) {
                if (splitLine[i].matches("\\S*\\d+\\S*")) {
                    clearLine.add(splitLine[i]);
                }
            }
            String readyLine = String.join(" ", clearLine);
            bufferedWriter.write(readyLine + " ");
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
