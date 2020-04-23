package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName));
        String line = "";
        while ((line = bufferedFileReader.readLine()) != null) {
            int count = 0;
            for (int i = 0; i < words.size(); i++) {
                String [] matches = (" " + line + " ").split("\\b" + words.get(i) + "\\b");
                count += matches.length -1;
            }
            if (count == 2) {
                System.out.println(line);
            }
        }
        bufferedFileReader.close();
    }
}
