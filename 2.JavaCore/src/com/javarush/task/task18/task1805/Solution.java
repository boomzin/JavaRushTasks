package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();
        while (fileInputStream.available() > 0) {
            treeSet.add(fileInputStream.read());
        }
        fileInputStream.close();
        while (!treeSet.isEmpty()) {
            System.out.print(treeSet.first() + " ");
            treeSet.remove(treeSet.first());
        }
    }
}
