package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/


import java.io.*;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFile = bufferedReader.readLine();
        String targetFile = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(targetFile));
        while (bufferedFileReader.ready()) {
            String readLine = bufferedFileReader.readLine();
//            System.out.println(readLine);
            Pattern digitPattern = Pattern.compile("\\b\\d+\\b");
            Matcher matcher = digitPattern.matcher(readLine);
            while (matcher.find()) {
                fileWriter.write(matcher.group(0) + " ");
            }
//            System.out.println();
        }
        bufferedFileReader.close();
        fileWriter.close();
    }
}
