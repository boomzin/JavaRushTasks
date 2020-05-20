package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);


        File newDestinationFile = new File(resultFileAbsolutePath.getParent() + File.separator + "allFilesContent.txt");

        if (FileUtils.isExist(newDestinationFile)) {
            FileUtils.deleteFile(newDestinationFile);
        }
        FileUtils.renameFile(resultFileAbsolutePath, newDestinationFile);

        List<File> smallFiles = getAllFiles(path);

        Collections.sort(smallFiles, Comparator.comparing(File::getName));

        FileOutputStream fos = new FileOutputStream(newDestinationFile);
        for (int i = 0; i < smallFiles.size(); i++) {
            FileInputStream fis = new FileInputStream(smallFiles.get(i));
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            fos.write(bytes);
            fos.write(10);
            fis.close();
        }
        fos.close();



    }

    public static List<File> getAllFiles(File path) throws IOException {
        List<File> fileList = new ArrayList<>();
        File[] fileArray = path.listFiles();
        for (int i = 0; i < fileArray.length; i++) {
            if (fileArray[i].isFile()) {
                if (fileArray[i].length() <= 50) {
                    fileList.add(fileArray[i]);
                }
            } else if (fileArray[i].isDirectory()) {
                List<File> tempList = getAllFiles(fileArray[i]);
                tempList.forEach((a) -> fileList.add(a));
            }
        }

        return fileList;
    }
}
