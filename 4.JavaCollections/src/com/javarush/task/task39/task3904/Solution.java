package com.javarush.task.task39.task3904;

import java.util.Arrays;

/* 
Лестница
*/

public class Solution {
    private static int n = 70;

    public static void main(String[] args) {
//        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
        System.out.println(numberOfPossibleAscents(0));
        System.out.println(numberOfPossibleAscents(1));
        System.out.println(numberOfPossibleAscents(2));
        System.out.println(numberOfPossibleAscents(3));
        System.out.println(numberOfPossibleAscents(4));
        System.out.println(numberOfPossibleAscents(5));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
//        if (n == 1) {
//            return 1;
//        }
        long count = 0;
        for (int one = 0; one <= n; one++) {

            for (int two = 1; two <= n / 2; two++) {

                for (int k = 0; k <= n - two; k++) {
                    if (two * 2 + k == n) {
                        count ++;
                    }
                }

                for (int three = 1; three <= n / 3; three++) {

                    for (int l = 0; l < n - three; l++) {
                        if (three * 3 + l * 2 == count) {
                            count ++;
                        }
                    }

                    if (one + 2 * two + 3 * three == n) {
                        count ++;
                    }
                }
            }
            if (one * n == n) {
                count ++;
            }
        }


        return count;
    }
}

