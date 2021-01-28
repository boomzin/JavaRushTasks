package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;
import sun.net.sdp.SdpSupport;

import java.util.Map;
import java.util.TreeMap;

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
        boolean exit = false;
        while (exit) {
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
                try {
                    TreeMap<Integer, Integer> withdraw = (TreeMap<Integer, Integer>) currencyManipulator.withdrawAmount(amount);
                    for (Map.Entry<Integer, Integer> entry : withdraw.entrySet()) {
                        ConsoleHelper.writeMessage("\t" + entry.getKey() + " - " + entry.getValue() + System.lineSeparator());
                    }
                    exit = true;
                    break;
                } catch (NotEnoughMoneyException e) {
                    ConsoleHelper.writeMessage("Try another amount" + System.lineSeparator());
                }
            }
        }
    }
}
