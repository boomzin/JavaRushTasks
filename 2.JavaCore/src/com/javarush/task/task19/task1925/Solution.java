package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));
        String line;
        List<String > longWord = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            String[] tempArray = line.split(" ");
            for (int i = 0; i < tempArray.length; i++) {
                if (tempArray[i].length() > 6) {
                    longWord.add(tempArray[i]);
                }
            }
        }
        String finalString = String.join(",", longWord);
        bufferedWriter.write(finalString);
        bufferedReader.close();
        bufferedWriter.close();
    }
}
