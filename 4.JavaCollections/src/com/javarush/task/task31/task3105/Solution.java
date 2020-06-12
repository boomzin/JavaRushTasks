package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, ByteArrayOutputStream> mapEntries = new HashMap<>();
//        ArrayList<ZipEntry> listZipEntries = new ArrayList<>();
//        ArrayList<ByteArrayOutputStream> listBAOS = new ArrayList<>();
        Path file = Paths.get(args[0]);
        String fileCheck = "new/" + file.getFileName();
        FileInputStream fileInputStream = new FileInputStream(args[1]);
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            if (zipEntry.getName().endsWith(String.valueOf(file.getFileName()))) {
                fileCheck = zipEntry.getName();
                zipInputStream.closeEntry();
            } else {
//                listZipEntries.add(zipEntry);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] bytes = new byte[1024];
                int count;
                while ((count = zipInputStream.read(bytes)) != -1) {
                    baos.write(bytes, 0, count);
                }
//                listBAOS.add(baos);
                mapEntries.put(zipEntry.getName(), baos);
            }
            zipInputStream.closeEntry();
        }
        zipInputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);
        ZipOutputStream zos = new ZipOutputStream(fileOutputStream);
        zos.putNextEntry(new ZipEntry(fileCheck));
        Files.copy(Paths.get(args[0]), zos);
//        zos.closeEntry();
        for (Map.Entry<String, ByteArrayOutputStream> entry :mapEntries.entrySet()) {
            zos.putNextEntry(new ZipEntry(entry.getKey()));
            zos.write(entry.getValue().toByteArray());
        }
        //        for (int i = 0; i < listZipEntries.size(); i++) {
//            zos.putNextEntry(listZipEntries.get(i));
//            zos.write(listBAOS.get(i).toByteArray());
//            zos.closeEntry();
//        }
        zos.close();
    }
}
