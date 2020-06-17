package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int position = Integer.parseInt(args[1]);
        String text = args[2];
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
        if (position > randomAccessFile.length()) {
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.write(text.getBytes());
        }else {
            randomAccessFile.seek(position);
            randomAccessFile.write(text.getBytes());
        }
    }
}
