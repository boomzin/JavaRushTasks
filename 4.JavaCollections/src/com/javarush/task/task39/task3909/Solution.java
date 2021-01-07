package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("xyz", "xxyz"));
    }

    public static boolean isOneEditAway(String first, String second) {
        int lengthDifference = first.length() - second.length();
        if (lengthDifference > 1 || lengthDifference < -1) {
            return false;
        }
        first = first.toLowerCase();
        second = second.toLowerCase();
        if (first.length() < second.length()) {
            String tmp = first;
            first = second;
            second = tmp;
        }
        for (int i = 0; i < first.length(); i++) {

            if (i == first.length() - 1 && first.length() > second.length()) {
                if (first.equals(second + first.substring(first.length() -1))) {
                    return true;
                }
                return false;
            }
            if (first.charAt(i) != second.charAt(i)) {
                String tmp = first.substring(0, i + 1) + second.substring(i);
                if (!first.equals(tmp)) {
                    tmp = first.substring(0, i) + second.substring(i).replaceFirst(String.valueOf(second.charAt(i)), String.valueOf(first.charAt(i)));
                    if (!first.equals(tmp)) {
                        return false;
                    }
                }
                return true;
            }
        }


        return true;

    }
}
