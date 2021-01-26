package com.javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String result = null;
        try {
            result = bis.readLine();
        } catch (IOException e) {
//            e.printStackTrace();
        }
        return result;
    }
    public static String askCurrencyCode() {
        String currencyCode = null;
        while (true) {
            System.out.print("Enter currency code: ");
            currencyCode = readString();
            if (currencyCode.length() == 3) {
                break;
            }
            System.out.println("Entered code is invalid");
        }
        return currencyCode.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) {
        int denomination = 0;
        int count = 0;
        while (true) {
            System.out.print("Enter denomination and count: ");
            String twoDigits = readString();
            Pattern pattern = Pattern.compile("(\\A\\d+ +\\d+\\Z)");
            Matcher matcher = pattern.matcher(twoDigits);
            if (matcher.find()) {
                return twoDigits.split(" ");
            }
            System.out.println("Entered denomination or count is invalid");
        }
    }

}
