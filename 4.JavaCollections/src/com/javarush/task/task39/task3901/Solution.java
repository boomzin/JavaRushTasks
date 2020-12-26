package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();
//        System.out.println(lengthOfLongestUniqueSubstring(null));
        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subString = s.substring(i, j + 1);
                char[] chars = subString.toCharArray();
                Set<Character> characterSet = new HashSet<>();
                for (Character character : chars) {
                    characterSet.add(character);
                }
                if (characterSet.size() == subString.length()) {
                    int subStringLength = subString.length();
                    if (subStringLength > maxLength) {
                        maxLength = subStringLength;
                    }
                }

            }
        }
        return maxLength;
    }
}
