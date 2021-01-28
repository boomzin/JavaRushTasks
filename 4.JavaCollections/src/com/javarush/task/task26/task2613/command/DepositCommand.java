package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

class DepositCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(ConsoleHelper.askCurrencyCode());
        String [] amountString = ConsoleHelper.getValidTwoDigits(currencyManipulator.getCurrencyCode());
        int [] amount = new int[2];
        amount[0] = Integer.valueOf(amountString[0]);
        amount[1] = Integer.valueOf(amountString[1]);
        currencyManipulator.addAmount(amount[0], amount[1]);
    }
}
