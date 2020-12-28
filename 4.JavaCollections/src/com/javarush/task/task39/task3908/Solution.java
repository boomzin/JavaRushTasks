package com.javarush.task.task39.task3908;

/* 
Возможен ли палиндром?
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("PiWpWoi"));
    }

    public static boolean isPalindromePermutation(String s) {
        int oddCount = 0;
        String[] strings = s.toLowerCase().split("");
        Set<String> stringSet = new HashSet<>(Arrays.asList(strings));
        for (String string : stringSet) {
            Pattern pattern = Pattern.compile(string);
            Matcher matcher = pattern.matcher(s.toLowerCase());
            int charCount = 0;
            while (matcher.find()) {
                charCount ++;
            }
            if (charCount % 2 != 0) {
                oddCount ++;
            }
        }
        System.out.println(Arrays.toString(strings));
        System.out.println(oddCount);
        if (oddCount > 1) {
            return false;
        }
        return true;
    }
}
