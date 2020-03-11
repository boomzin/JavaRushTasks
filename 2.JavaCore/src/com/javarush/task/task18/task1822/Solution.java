package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader lineReader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = lineReader.readLine()) != null) {
            if (line.substring(0, line.indexOf(" ")).equals(args[0])) {
                System.out.println(line);
            }
        }
        lineReader.close();
    }
}
