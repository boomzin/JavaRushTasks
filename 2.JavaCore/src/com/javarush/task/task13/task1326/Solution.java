package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String path=bufferedReader.readLine();
        FileInputStream fileInputStream=new FileInputStream(path);
        ArrayList<Integer> arrayList=new ArrayList();
        String line;
        BufferedReader readerFromFile=new BufferedReader(new InputStreamReader(fileInputStream));
        while ((line=readerFromFile.readLine())!=null){
            if (Integer.parseInt(line)%2==0){
                arrayList.add(Integer.parseInt(line));
            }
        }
        Collections.sort(arrayList);
        for (int j = 0; j < arrayList.size() ; j++) {
            System.out.println(arrayList.get(j));
        }

        fileInputStream.close();
        bufferedReader.close();
        readerFromFile.close();

        // напишите тут ваш код
    }
}
