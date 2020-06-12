package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        int BUFFER = 2048;
        int readBytes;
        byte[] bytes = new byte[BUFFER];
        FileOutputStream fileOutputStream = new FileOutputStream(args[0]);
        ArrayList<InputStream> listInputSream = new ArrayList<>();
        ArrayList<String> fileNameList = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            fileNameList.add(args[i]);
        }
        Collections.sort(fileNameList);
        for (int i = 0; i < fileNameList.size(); i++) {
            listInputSream.add(new FileInputStream(fileNameList.get(i)));
        }

        ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(listInputSream)));
        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            while ((readBytes = zipInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, readBytes);
            }
            zipInputStream.closeEntry();
        }
        zipInputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
