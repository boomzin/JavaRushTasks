package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> fileNameList = new ArrayList<>();
        File rootFile = new File(root);
        File[] fileArray = rootFile.listFiles();
        LinkedList<File> fileList = new LinkedList<>();
        Collections.addAll(fileList, fileArray);
        while (fileList.size() != 0) {
            File searchedFile = fileList.getFirst();
            if (searchedFile.isFile()){
                fileNameList.add(searchedFile.getCanonicalPath());
                fileList.removeFirst();
            } else if (searchedFile.isDirectory()) {
                fileArray = searchedFile.listFiles();
                fileList.removeFirst();
                Collections.addAll(fileList, fileArray);
            }
        }


        return fileNameList;

    }

    public static void main(String[] args) throws IOException {
        List<String> list = getFileTree("d:\\testfiles");
        list.forEach(a -> System.out.println(a));
    }
}
