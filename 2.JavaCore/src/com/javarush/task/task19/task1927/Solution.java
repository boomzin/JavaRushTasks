package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream old = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(byteArrayOutputStream);
        System.setOut(newOut);
        testString.printSomething();
        newOut.close();
        System.setOut(old);
        String lines = byteArrayOutputStream.toString();
        byteArrayOutputStream.close();
        String[] linesArray = lines.split(System.lineSeparator());
        List<String> linesList = Arrays.asList(linesArray);
        int count = 0;
        for (int i = 0; i < linesList.size(); i++) {
            count ++;
            System.out.println(linesList.get(i));
            if (count == 2) {
                count = 0;
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
