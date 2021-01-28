package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

class WithdrawCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        int amount = 0;
        String currency;
        CurrencyManipulator currencyManipulator = null;
        while (true) {
            currency = ConsoleHelper.askCurrencyCode();
            if (CurrencyManipulatorFactory.getAllCurrency().contains(currency.toUpperCase())) {
                currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);
                break;
            }
        }

        while (true) {
            while (true) {
                ConsoleHelper.writeMessage("Enter amount: ");
                try {
                    amount = Integer.valueOf(ConsoleHelper.readString());
                    break;
                } catch (NumberFormatException e) {
                    ConsoleHelper.writeMessage("Entered amount is invalid" + System.lineSeparator());
                }
            }
            if (currencyManipulator.isAmountAvailable(amount)) {
                currencyManipulator.withdrawAmount(amount);
            }
        }
    }
}
