package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int first = 0;
        int second = 0;
//        System.out.println("Введите два целых положительных числа");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        first = Integer.parseInt(bufferedReader.readLine());
        second = Integer.parseInt(bufferedReader.readLine());

        if (first <= 0 || second <= 0 ) {
            throw new Exception();
        }

        System.out.println(nod(first,second));
        bufferedReader.close();
    }
    static int nod(int a, int b) {
       int t =0;
        for (int i = 1; i <= a; i++) {
            if ((a % i == 0) && (b % i == 0)){
                t = i;
            }
        }
        return t;
    }
}

