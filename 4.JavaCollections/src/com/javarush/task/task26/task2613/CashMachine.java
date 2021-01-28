package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

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
