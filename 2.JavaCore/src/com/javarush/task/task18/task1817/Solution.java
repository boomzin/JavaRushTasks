package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int countSymbol = 0;
        int countSpace = 0;
        while (fileInputStream.available() > 0) {
            countSymbol++;
            int symbol = fileInputStream.read();
            if (symbol == 32) {
                countSpace ++;
            }
        }
        fileInputStream.close();
        if (countSymbol > 0) {
            float ratio = (float) countSpace / countSymbol;
            ratio = ratio * 10000;
            int intRatio = Math.round(ratio);
            ratio = (float) intRatio / 100;
            System.out.println(ratio);
        } else {
            System.out.println(0);
        }
    }
}
