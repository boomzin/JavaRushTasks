package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

//        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode("rub");
//        System.out.println(currencyManipulator.withdrawAmount(153).toString());
        while (true) {
            try {
                CommandExecutor.execute(ConsoleHelper.askOperation());
            } catch (InterruptOperationException e) {
                ConsoleHelper.writeMessage("GoodBye");
                return;
            }
        }
    }
}
