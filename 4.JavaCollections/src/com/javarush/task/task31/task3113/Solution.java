package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {
    private static long[] info = new long[3];
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(bufferedReader.readLine());
        if (Files.isDirectory(path)) {
            MyVisitor myVisitor = new Solution.MyVisitor();
            Files.walkFileTree(path, myVisitor);
            System.out.println("Всего папок - " + (info[0] - 1));
            System.out.println("Всего файлов - " + info[1]);
            System.out.println("Общий размер - " + info[2]);
        } else {
            System.out.println(path + " - не папка");
        }
    }

    public static class MyVisitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            info[0] ++;
            return super.preVisitDirectory(dir, attrs);
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            info[1] ++;
            info[2] += attrs.size();
            return super.visitFile(file, attrs);
        }
    }
}
