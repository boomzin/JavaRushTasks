package com.javarush.task.task34.task3402;

/* 
Факториал с помощью рекурсии
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.factorial(9));     //362880
        System.out.println(solution.factorial(0));     //1
        System.out.println(solution.factorial(1));     //1
    }

    public int factorial(int n) {
        int multiply;
        if ((n - 1) > 0) {
            multiply = n * factorial(n - 1);
        } else {
            multiply = 1;
        }
        return multiply;
    }
}
