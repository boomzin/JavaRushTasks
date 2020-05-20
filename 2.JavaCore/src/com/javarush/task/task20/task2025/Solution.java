package com.javarush.task.task20.task2025;


import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {
    static long [][] powersTable;
    static byte base = 10;
    static long[] dimensionArray;
    static TreeSet<Long> sortedResult = null;
    static long maxValue;


    public static long[] getNumbers(long N) {
        long[] result = null;
        if ((N <= 0) | (N > Long.MAX_VALUE)) {
            return result;
        }
        maxValue = N;
        sortedResult = new TreeSet<>();
        int lengthOrder = String.valueOf(N - 1).length();
        powersTable = new long[10][lengthOrder + 1];

        for (int i = 0; i <= 9; i++) {
            powersTable[i][0] = i;
            for (int j = 1; j <= lengthOrder; j++) {
                powersTable[i][j] = powersTable[i][j - 1] * powersTable[i][0];
            }
        }

        for (int i = 1; i <= lengthOrder; i++) {
            dimensionArray = null;
            dimensionArray = new long[i];
            combinationWithRepetition(0, 0);
        }
        result = new long[sortedResult.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = sortedResult.pollFirst();
        }

        return result;
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(9474L)));
        long stop = System.currentTimeMillis();
        long time = stop - start;
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("time " + time);
        System.out.println("memory " + memory / 1048576);
    }


    public static void combinationWithRepetition(int position, int firstSymbol) {
        if (position == dimensionArray.length) {
            long tmp = 0;
            for (int i = 0; i < dimensionArray.length; i++) {
                tmp += powersTable[ (int) dimensionArray[i]][dimensionArray.length - 1];
            }
            if (tmp > 0 && tmp < maxValue && isNarc(tmp)) {
                sortedResult.add(tmp);
            }
        } else {
            for (int i = firstSymbol; i < base ; i++) {
                dimensionArray[position] = i;
                combinationWithRepetition(position + 1, i);
            }
        }
    }

    public static boolean isNarc(long x){
        int m = String.valueOf(x).length();
        long oldX = x;
        long sum = 0;
        while (x != 0) {
            sum += powersTable[(int) (x % base)][m - 1];
            x /= base;
        }
        return sum == oldX;
    }


}
