package com.javarush.task.task26.task2613;

import java.util.Locale;

public class CashMachine {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(ConsoleHelper.askCurrencyCode());
        String [] amountString = ConsoleHelper.getValidTwoDigits(currencyManipulator.getCurrencyCode());
        int [] amount = new int[2];
        amount[0] = Integer.valueOf(amountString[0]);
        amount[1] = Integer.valueOf(amountString[1]);
        currencyManipulator.addAmount(amount[0], amount[1]);

    }
}
