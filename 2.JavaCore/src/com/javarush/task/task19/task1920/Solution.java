package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        TreeMap<String, Double> sortedMap = new TreeMap<>();
        Double maxValue = 0.;
        while ((line = bufferedReader.readLine()) != null) {
            String key = line.substring(0, line.indexOf(" "));
            Double value = Double.parseDouble(line.substring(line.indexOf(" ")));
            sortedMap.merge(key, value, (a, b) -> sortedMap.get(key) + b);
            if (sortedMap.get(key) > maxValue) {
                maxValue = sortedMap.get(key);
            }
        }
        fileReader.close();
        bufferedReader.close();
        Double finalMaxValue = maxValue;
        sortedMap.forEach((a, b) -> {
            if (finalMaxValue.equals(b)) {
                System.out.println(a);
            }
        });
    }
}
