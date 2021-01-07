package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/

public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " " + isPowerOfThree(i));
        }
    }

    public static boolean isPowerOfThree(int n) {
//        if (n % 3 == 0) {
//            return true;
//        }
//        return false;
        if (n == 0) {
            return false;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1? true: false;
    }
}
