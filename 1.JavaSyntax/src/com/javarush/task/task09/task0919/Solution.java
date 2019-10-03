package com.javarush.task.task09.task0919;

/* 
Деление на ноль
*/

import com.sun.org.apache.bcel.internal.generic.VariableLengthInstruction;

public class Solution {

    public static void main(String[] args) {
        try {
            divideByZero();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }


    public static void divideByZero() throws ArithmeticException {
        int b=15;
        System.out.println(b/0);
    }
}
