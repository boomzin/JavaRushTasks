package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {


    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.isEmpty()) return false;

        boolean leftBracket = false;
        boolean rightBracket = false;
        boolean metBrackets = false;
        int hyphenCount = 0;
        int digitsInBrackets = 0;
        int count = 0;
        int expectedLength = 10;


        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(telNumber);

        while (matcher.find()) {
            if (matcher.start() != 0) {
                String start = telNumber.substring(0, matcher.start());
                switch (start) {
                    case "+":
                        if (count > 0) return false;
                        expectedLength = 12;
                        break;
                    case "(":
                        if (metBrackets || hyphenCount > 0) return false;
                        leftBracket = true;
                        break;
                    case  ")":
                        if (metBrackets || !leftBracket || digitsInBrackets != 3) return false;
                        metBrackets = true;
                        rightBracket = true;
                        leftBracket = false;
                        break;
                    case "-":
                        if (hyphenCount > 2 || (!metBrackets & leftBracket)) return false;
                        hyphenCount ++;
                        break;
                    default: return false;
                }
            }
            telNumber = telNumber.substring(matcher.end());
            matcher.reset(telNumber);
            if (leftBracket && !rightBracket) digitsInBrackets ++;
            count++;
        }
        if (count != expectedLength) return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber(null));
        System.out.println(checkTelNumber(""));
        System.out.printf("%-8s %-20s %-7s %-5s %-9s %-6s%n", "Check - ", "+380501234567","return", checkTelNumber("+380501234567"), "expected", "true");
        System.out.printf("%-8s %-20s %-7s %-5s %-9s %-6s%n", "Check - ", "+38(050)1234567","return", checkTelNumber("+38(050)1234567"), "expected", "true");
        System.out.printf("%-8s %-20s %-7s %-5s %-9s %-6s%n", "Check - ", "(050)1234563","return", checkTelNumber("(050)1234563"), "expected", "true");
        System.out.printf("%-8s %-20s %-7s %-5s %-9s %-6s%n", "Check - ", "+3-8(050)1234567","return", checkTelNumber("+3-8(050)1234567"), "expected", "false");
        System.out.printf("%-8s %-20s %-7s %-5s %-9s %-6s%n", "Check - ", "+38(0-50)1234567","return", checkTelNumber("+38(0-50)1234567"), "expected", "false");
        System.out.printf("%-8s %-20s %-7s %-5s %-9s %-6s%n", "Check - ", "+38(0-501234567","return", checkTelNumber("+38(0-501234567"), "expected", "false");
        System.out.printf("%-8s %-20s %-7s %-5s %-9s %-6s%n", "Check - ", "+380-50)1234567","return", checkTelNumber("+380-50)1234567"), "expected", "false");
        System.out.printf("%-8s %-20s %-7s %-5s %-9s %-6s%n", "Check - ", "+38050123-45-67","return", checkTelNumber("+38050123-45-67"), "expected", "true");
        System.out.printf("%-8s %-20s %-7s %-5s %-9s %-6s%n", "Check - ", "+050123-4567","return", checkTelNumber("050123-4567"), "expected", "true");
        System.out.printf("%-8s %-20s %-7s %-5s %-9s %-6s%n", "Check - ", "+050123--4567","return", checkTelNumber("050123--4567"), "expected", "false");
        System.out.printf("%-8s %-20s %-7s %-5s %-9s %-6s%n", "Check - ", "+38)050(1234567","return", checkTelNumber("+38)050(1234567"), "expected", "false");
        System.out.printf("%-8s %-20s %-7s %-5s %-9s %-6s%n", "Check - ", "+38(0501)234567","return", checkTelNumber("+38)050(1234567"), "expected", "false");
        System.out.printf("%-8s %-20s %-7s %-5s %-9s %-6s%n", "Check - ", "+38(050)1-23-45-6-7","return", checkTelNumber("+38(050)1-23-45-6-7"), "expected", "false");
        System.out.printf("%-8s %-20s %-7s %-5s %-9s %-6s%n", "Check - ", "050ххх4567","return", checkTelNumber("050ххх4567"), "expected", "false");
        System.out.printf("%-8s %-20s %-7s %-5s %-9s %-6s%n", "Check - ", "050123456","return", checkTelNumber("050123456"), "expected", "false");
        System.out.printf("%-8s %-20s %-7s %-5s %-9s %-6s%n", "Check - ", "(0)501234567","return", checkTelNumber("(0)501234567"), "expected", "false");
    }
}
//        String r1 = "((\\+\\d{2})?\\(\\d{3}\\)\\d{7})"; //(123)4567890  +38(050)1234567
//        String r2 = "^((\\+\\d{2})?(\\(\\d{3}\\))?(\\d{10}|\\d{7}))$"; //(123)4567890  +38(050)1234567 +380501234567   0123456789