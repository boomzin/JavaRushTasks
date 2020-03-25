package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        bufferedReader.close();
        String fileContain = "";
        while (fileReader.ready()) {
            fileContain = fileContain + (char) fileReader.read();
        }
        Pattern wordPattern =  Pattern.compile("\\bworld\\b");
        Matcher fileMatcher = wordPattern.matcher(fileContain);
        int findCount = 0;
        while (fileMatcher.find()) {
            findCount++;
        }
        fileReader.close();
        System.out.println(findCount);
    }
}
