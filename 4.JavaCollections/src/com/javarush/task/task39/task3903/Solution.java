package com.javarush.task.task39.task3903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Неравноценный обмен
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        swapBits(247, 6, 3);
//        System.out.println();
//        System.out.println(Long.toBinaryString(255));
//        System.out.println(Long.toBinaryString(255 >> 2));
//        System.out.println(Long.toBinaryString(255 >> -2));
        System.out.println("Please enter a number: ");

        long number = Long.parseLong(reader.readLine());
        System.out.println("Please enter the first index: ");
        int i = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the second index: ");
        int j = Integer.parseInt(reader.readLine());

        System.out.println("The result of swapping bits is " + swapBits(number, i, j));
    }

    public static long swapBits(long number, int i, int j) {
        if (i > j) {
            int tmp = i;
            i = j;
            j = tmp;
        }
        long first = (number >> i) & 1;
        long second = (number >> j) & 1;
//        System.out.println(Long.toBinaryString(number));
//        System.out.println(first);
//        System.out.println(second);
        if (first == second) {
            return number;
        }
        long reverse = ((1 << (j - i)) | 1) << i;
//        System.out.println(Long.toBinaryString(reverse));
        number = number ^ reverse;
//        System.out.println(Long.toBinaryString(number));
        return number;
    }
}
