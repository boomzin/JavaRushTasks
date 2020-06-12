package com.javarush.task.task31.task3112;

import com.sun.jndi.toolkit.url.UrlUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();

//        Path tempDir = Files.createTempDirectory("tempDir");
        Files.createDirectories(downloadDirectory);

        String filename = downloadDirectory.toString() + File.separator + Paths.get(url.getPath()).getFileName();

        Path file = Files.createTempFile("temp-", ".tmp");

        Files.copy(inputStream, file, StandardCopyOption.REPLACE_EXISTING);
//        inputStream.close();

        return Files.move(file, Paths.get(filename), StandardCopyOption.REPLACE_EXISTING);
    }
}
