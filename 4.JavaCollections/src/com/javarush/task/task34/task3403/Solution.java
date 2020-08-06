package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recurse(int n) {

        for (int i = 2; i <= n; i++) {
            if (n % i == 0 & i != n) {
                System.out.print(i + " ");
                recurse(n / i);
                break;
            } else if (n % i == 0 & i == n) {
                System.out.print(n + " ");
            }
        }


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse(46456498);
    }
}
