package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(new File(args[2]));
        if ("-e".equals(args[0])) {
            while (fileInputStream.available()>0) {
                int readingByte = fileInputStream.read();
                if (readingByte >= 128) {
                    fileOutputStream.write(readingByte - 127);
                } else {
                    fileOutputStream.write(readingByte + 127);
                }

            }
        } else if ("-d".equals(args[0])) {
            while (fileInputStream.available()>0) {
                int readingByte = fileInputStream.read();
                if (readingByte >= 128) {
                    fileOutputStream.write(readingByte - 127);
                } else {
                    fileOutputStream.write(readingByte + 127);
                }
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

}
