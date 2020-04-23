package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFile = bufferedReader.readLine();
        bufferedReader.close();
        FileReader fileReader = new FileReader(sourceFile);
        BufferedReader bFileReader = new BufferedReader(fileReader);
        String line;
        while ((line = bFileReader.readLine()) != null) {
            Pattern pattern = Pattern.compile("\\b[0-9]\\b|\\b(11|12)\\b");
            Matcher matcher = pattern.matcher(line);
            String readyLine = line;
            while (matcher.find()) {
                String foundEntry = line.substring(matcher.start(), matcher.end());
                readyLine = readyLine.replaceFirst("\\b[0-9]\\b|\\b(11|12)\\b", map.get(Integer.parseInt(foundEntry)));
            }
            System.out.println(readyLine);
        }
        fileReader.close();
        bFileReader.close();
    }
}
