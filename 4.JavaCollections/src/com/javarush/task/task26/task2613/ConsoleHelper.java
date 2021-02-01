package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    public static void writeMessage(String message) {
        System.out.print(message);
    }

    public static String readString() throws InterruptOperationException {
        String result = null;
        try {
            result = bis.readLine();
        } catch (IOException e) {
        }
        if ("exit".equals(result.toLowerCase())) {
            throw new InterruptOperationException();
        }
        return result;
    }
    public static String askCurrencyCode() throws InterruptOperationException {
        String currencyCode = null;
        while (true) {
            System.out.print(res.getString("choose.currency.code"));
            currencyCode = readString();
            if (currencyCode.length() == 3) {
                break;
            }
            System.out.println(res.getString("invalid.data"));
        }
        return currencyCode.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        int denomination = 0;
        int count = 0;
        while (true) {
            System.out.print(res.getString("choose.denomination.and.count.format"));
            String twoDigits = readString();
            Pattern pattern = Pattern.compile("(\\A\\d+ +\\d+\\Z)");
            Matcher matcher = pattern.matcher(twoDigits);
            if (matcher.find()) {
                return twoDigits.split(" ");
            }
            System.out.println(res.getString("invalid.data"));
        }
    }

    public static Operation askOperation() throws InterruptOperationException{
        while (true) {
            try {
                System.out.println(res.getString("choose.operation") + System.lineSeparator()
                        + " 1." + res.getString("operation.INFO")
                        + " 2." + res.getString("operation.DEPOSIT")
                        + " 3." + res.getString("operation.WITHDRAW")
                        + " 4." + res.getString("operation.EXIT"));
                return Operation.getAllowableOperationByOrdinal(Integer.valueOf(readString()));
            } catch (IllegalArgumentException e) {
                System.out.println(res.getString("invalid.data"));
            }
        }
    }

    public static void printExitMessage() {
        System.out.println(res.getString("the.end"));
    }

}
