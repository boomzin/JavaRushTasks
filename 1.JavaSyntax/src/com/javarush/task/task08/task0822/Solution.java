package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        Collections.sort(array);
//        System.out.println(array);
        // Найти минимум тут
        return array.get(0);
    }

    public static List<Integer> getIntegerList() throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list=new ArrayList<>();
        int size=Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < size; i++) {
            int number=Integer.parseInt(bufferedReader.readLine());
            list.add(number);
        }
        // Создать и заполнить список тут
        return list;
    }
}
