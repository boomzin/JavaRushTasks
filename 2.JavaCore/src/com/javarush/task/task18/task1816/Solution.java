package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/


import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
        int count = 0;
        while (file.available() > 0) {
//            Character symbol = (char) file.read();
//            System.out.println(symbol);
            int symbol = file.read();
            if ((symbol >= 56 & symbol <= 90) | (symbol >= 97 & symbol <= 122)) {
                count++;
            }
        }
        file.close();
        System.out.println(count);

    }
}
