package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldOut = System.out;
        ByteArrayOutputStream byteArrayOutputStream =  new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(byteArrayOutputStream);
        System.setOut(newOut);
        testString.printSomething();
        String line = byteArrayOutputStream.toString();
        String [] mathLine = line.split(" ");
        int firstOperand = Integer.parseInt(mathLine[0]);
        int secondOperand = Integer.parseInt(mathLine[2]);
        int result =0;
        if ("+".equals(mathLine[1])) {
            result = firstOperand + secondOperand;
        } else if ("-".equals(mathLine[1])) {
            result = firstOperand - secondOperand;
        } else if ("*".equals(mathLine[1])) {
            result = firstOperand * secondOperand;
        }

        System.setOut(oldOut);
        System.out.print(line.replaceAll(System.getProperty("line.separator"), "") + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

