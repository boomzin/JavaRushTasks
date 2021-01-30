package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

public class LoginCommand implements Command{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.verifiedCards", Locale.ENGLISH);
    @Override
    public void execute() throws InterruptOperationException {
        String cardString = "";
        String pinString = "";
        while (true) {
            while (true) {
                ConsoleHelper.writeMessage("Enter card number: ");
                cardString = ConsoleHelper.readString();
                if (cardString.length() == 12) {
                    break;
                }
                ConsoleHelper.writeMessage("Cars number is invalid" + System.lineSeparator());
            }
            while (true) {
                ConsoleHelper.writeMessage("Enter pin: ");
                pinString = ConsoleHelper.readString();
                if (pinString.length() == 4) {
                    break;
                }
                ConsoleHelper.writeMessage("Pin is invalid" + System.lineSeparator());
            }
            if (validCreditCards.containsKey(cardString) && pinString.equals(validCreditCards.getString(cardString))) {
                ConsoleHelper.writeMessage("Login successful" + System.lineSeparator());
                break;
            }
            ConsoleHelper.writeMessage("Login data is invalid" + System.lineSeparator());
            }
        }
}
