package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while (fileInputStream.available() > 0) {
            int readByte = fileInputStream.read();
            Integer frequency = hashMap.get(readByte);
            hashMap.put(readByte, frequency == null ? 1: ++frequency);
        }
        fileInputStream.close();
        List<Integer> list = new ArrayList<>();
        list.addAll(hashMap.values());
        Collections.sort(list);
        int minFrequency = list.get(0);
        for (Map.Entry entry: hashMap.entrySet()) {
            if (entry.getValue().equals(minFrequency)) {
                System.out.print(entry.getKey() + " ");
            }
        }

    }
}
