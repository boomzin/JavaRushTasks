package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        int [] a = new int [20];
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <20 ; i++) {
            a[i]=Integer.parseInt(bufferedReader.readLine());
        }
        // создай и заполни массив
        return a;
    }

    public static int max(int[] array) {
        int m=array[0];
        for (int i = 1; i <20 ; i++) {
            if (array[i]>m){
                m=array[i];
            }
        }
        // найди максимальное значение
        return m;
    }
}
