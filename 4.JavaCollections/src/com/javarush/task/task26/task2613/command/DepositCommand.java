package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");
    @Override
    public void execute() throws InterruptOperationException {
        System.out.println(res.getString("before"));
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(ConsoleHelper.askCurrencyCode());
        String [] amountString = ConsoleHelper.getValidTwoDigits(currencyManipulator.getCurrencyCode());
        int [] amount = new int[2];
        try {
            amount[0] = Integer.valueOf(amountString[0]);
            amount[1] = Integer.valueOf(amountString[1]);
            currencyManipulator.addAmount(amount[0], amount[1]);
            System.out.printf(res.getString("success.format")  + System.lineSeparator(),amount[0] * amount[1], currencyManipulator.getCurrencyCode());
        } catch (NumberFormatException e) {
            System.out.println(res.getString("invalid.data"));;
        }
    }
}
