package com.javarush.task.task39.task3904;


/* 
Лестница
*/

public class Solution {
    private static int n = 70;

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
        System.out.println(numberOfPossibleAscents(0));
        System.out.println(numberOfPossibleAscents(1));
        System.out.println(numberOfPossibleAscents(2));
        System.out.println(numberOfPossibleAscents(3));
        System.out.println(numberOfPossibleAscents(4));
        System.out.println(numberOfPossibleAscents(5));
        System.out.println(numberOfPossibleAscents(6));
        System.out.println(numberOfPossibleAscents(7));
        System.out.println(numberOfPossibleAscents(8));
        System.out.println(numberOfPossibleAscents(9));
        System.out.println(numberOfPossibleAscents(10));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        Long[] threebonachi = new Long[n + 2];
        threebonachi[0] = 1L;
        threebonachi[1] = 1L;
        threebonachi[2] = 2l;
        for (int i = 3; i <= n; i++) {
            threebonachi[i] = threebonachi[i -1] + threebonachi[i - 2] + threebonachi[i - 3];
        }
        return threebonachi[n];
    }
}

