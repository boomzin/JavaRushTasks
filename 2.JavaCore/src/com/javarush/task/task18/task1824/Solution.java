package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<FileInputStream> streamList = new ArrayList<>();
        String fileName = "";
        while (true) {
            try {
                fileName = reader.readLine();
                streamList.add(new FileInputStream(fileName));
            } catch (FileNotFoundException e) {
                for (int i = 0; i < streamList.size(); i++) {
                    try {
                        streamList.get(i).close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                try {
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println(fileName);
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
