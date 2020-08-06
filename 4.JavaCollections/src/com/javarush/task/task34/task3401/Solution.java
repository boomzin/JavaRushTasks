package com.javarush.task.task34.task3401;

/* 
Числа Фибоначчи с помощью рекурсии
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();



        System.out.println(solution.fibonacci(9));     //34
        System.out.println(solution.fibonacci(5));     //5
        System.out.println(solution.fibonacci(2));     //1
        System.out.println(solution.fibonacci(1));     //1
    }

    public int fibonacci(int n) {
        int sum = 0;
        int nextStep = n - 2;
        if (nextStep > 0) {
            sum = fibonacci(nextStep) + fibonacci(n - 1);
        } else {
            sum = 1;
        }
        return sum;
    }
}
