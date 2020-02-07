package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filename);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while (fileInputStream.available() > 0) {
            int tmp = fileInputStream.read();
            Integer frequency = hashMap.get(tmp);
            hashMap.put(tmp, frequency == null? 1: frequency + 1);
        }
        fileInputStream.close();
        List<Integer> list = new ArrayList<>();
        list.addAll(hashMap.values());
        Collections.sort(list);
        int max = list.get(list.size()-1);
//        System.out.println(max);
        for (Map.Entry entry: hashMap.entrySet()) {
            if (entry.getValue().equals(max)) {
                System.out.print(entry.getKey() + " ");
            }
        }
        bufferedReader.close();
//        fileInputStream.close();

        
    }
}
