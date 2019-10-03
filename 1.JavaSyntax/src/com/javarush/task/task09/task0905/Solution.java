package com.javarush.task.task09.task0905;

/* 
Там, в синих глубинах стек-трейса…
*/

public class Solution {
    public static void main(String[] args) {
        int deep = getStackTraceDeep();
    }

    public static int getStackTraceDeep() {
        StackTraceElement[] stackTraceElement=Thread.currentThread().getStackTrace();
        int stackTraceDeep=stackTraceElement.length;
        System.out.println(stackTraceDeep);
        return stackTraceDeep;
        //напишите тут ваш код
    }
}

