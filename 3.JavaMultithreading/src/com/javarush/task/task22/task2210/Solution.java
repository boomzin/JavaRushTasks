package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        String[] strings = getTokens("level22.lesson13.task01", ".");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static String[] getTokens(String query, String delimiter) {
        List<String> strings = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens()) {
            strings.add(tokenizer.nextToken());
        }
        return strings.toArray(new String[0]);
    }
}
