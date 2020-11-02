package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String allString = "";
        while (bufferedReader.ready()) {
            allString += bufferedReader.readLine().toLowerCase();
        }
        bufferedReader.close();
        TreeSet<Character> treeSet = new TreeSet<>();
        for (int i = 0; i < allString.length(); i++) {
            if (Character.isLetter(allString.charAt(i))) {
                treeSet.add(allString.charAt(i));
            }
        }
        treeSet.stream()
                .limit(5)
                .forEach(System.out::print);
    }
}
