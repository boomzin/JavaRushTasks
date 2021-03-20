package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        Path path = Paths.get(fileName);
        List<String> strings = Files.readAllLines(path, Charset.defaultCharset());
        List<String> words = new ArrayList<>();
        for (String string : strings) {
            words.addAll(Arrays.asList(string.split(" ")));
        }
        StringBuilder result = getLine(words.toArray(new String[strings.size()]));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0) return new StringBuilder("");

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        result.add(new ArrayList<String>());

        for (int i = 0; i < words.length; i++) {
            ArrayList<ArrayList<String>> current = new ArrayList<>();

            Iterator<ArrayList<String>> resultIter = result.iterator();
            while (resultIter.hasNext()){
                ArrayList<String> l = resultIter.next();
                for (int j = 0; j < l.size()+1; j++) {
                    l.add(j, words[i]);

                    ArrayList<String> temp = new ArrayList<>(l);
                    if (temp.size() == words.length) {
                        boolean suited = true;
                        StringBuilder stringBuilder = new StringBuilder("");
                        for (int k = 0; k < temp.size() - 1; k++) {
                            if (!temp.get(k).substring(temp.get(k).length() -1).toUpperCase().equals(temp.get(k + 1).substring(0, 1).toUpperCase())) {
                                suited = false;
                                break;
                            }
                            stringBuilder.append(temp.get(k) + " ");
                        }
                        if (suited) {
                            return stringBuilder.append(temp.get(temp.size() - 1));
                        }
                    }
                    current.add(temp);
                    l.remove(j);
                }
            }
            result =new ArrayList<>(current);
        }
        return new StringBuilder("");
    }
}
