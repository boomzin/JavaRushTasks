package com.javarush.task.task13.task1319;

import java.awt.*;
import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter(bufferedReader.readLine()));
        String line;
        while (!(line=bufferedReader.readLine()).equals("exit")){
            bufferedWriter.write(line+'\n');
        }
        bufferedWriter.write(line+'\n');
        bufferedReader.close();
        bufferedWriter.close();

        // напишите тут ваш код
    }
}
