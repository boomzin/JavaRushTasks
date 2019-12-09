package com.javarush.task.task15.task1517;

/* 
Статики и исключения
*/

import jdk.nashorn.internal.runtime.ECMAException;

public class Solution {
    public static int A = 0;
//    public Solution() throws Exception{
//
//    }

    static {
        if (true){
            throw new RuntimeException();
        }
        //throw an exception here - выбросьте эксепшн тут
    }

    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}
