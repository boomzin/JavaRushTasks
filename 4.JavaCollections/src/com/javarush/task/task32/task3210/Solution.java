package com.javarush.task.task32.task3210;

/* 
 RandomAccessFile
*/

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        int position = Integer.parseInt(args[1]);
        String text = args[2];
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
        randomAccessFile.seek(position);
        byte[] bytes = new byte[text.length()];
        randomAccessFile.read(bytes, 0, text.length());
        String fileText = new  String(bytes, Charset.defaultCharset());
        randomAccessFile.seek(randomAccessFile.length());
        if (text.equals(fileText)) {
            randomAccessFile.write("true".getBytes());
        } else {
            randomAccessFile.write("false".getBytes());
        }

    }
}
