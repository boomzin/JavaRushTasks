package com.javarush.task.task39.task3902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Биты были биты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number: ");

        long l = Long.parseLong(reader.readLine());
        String result = isWeightEven(l) ? "even" : "odd";
        System.out.println("The entered number has " + result + "ones");

//        int digit = 3;
//        System.out.println(digit & 1);

    }

    public static boolean isWeightEven(long number) {
        int count = 0;
//        System.out.println(Long.toBinaryString(number));
        while (number != 0) {
            if ((number & 1) == 1) {
                count ++;
            }
            number >>>= 1;
        }
//        System.out.println(count);
        return (count & 1) == 1? false: true;
    }
}
