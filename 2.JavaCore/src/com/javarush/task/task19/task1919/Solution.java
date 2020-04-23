package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/



import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        TreeMap <String, Double> tree = new TreeMap<>();
        while ((line = bufferedReader.readLine()) != null) {
            String key = line.substring(0, line.indexOf(" "));
            Double value = Double.parseDouble(line.substring(line.indexOf(" ")));
            if (tree.containsKey(key)) {
                tree.replace(key,tree.get(key), tree.get(key) + value);
            } else {
                tree.put(key, value);
            }
        }
        fileReader.close();
        bufferedReader.close();
        for (Map.Entry entry: tree.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());

        }
    }
}
