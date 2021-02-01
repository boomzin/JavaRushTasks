package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

public class LoginCommand implements Command{
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");
    @Override
    public void execute() throws InterruptOperationException {
        System.out.println(res.getString("before"));
        String cardString = "";
        String pinString = "";
        while (true) {
            while (true) {
                ConsoleHelper.writeMessage(res.getString("specify.data") + ": ");
                cardString = ConsoleHelper.readString();
                if (cardString.length() == 12) {
                    break;
                }
                System.out.printf(res.getString("not.verified.format") + System.lineSeparator(), cardString);
            }
            System.out.printf(res.getString("success.format") + System.lineSeparator(), cardString);
            while (true) {
                ConsoleHelper.writeMessage("Enter pin: ");
                pinString = ConsoleHelper.readString();
                if (pinString.length() == 4) {
                    break;
                }
                System.out.printf(res.getString("success.format") + System.lineSeparator(), cardString);
            }
            if (validCreditCards.containsKey(cardString) && pinString.equals(validCreditCards.getString(cardString))) {
                System.out.printf(res.getString("success.format") + System.lineSeparator(), cardString);
                break;
            }
            ConsoleHelper.writeMessage(res.getString("try.again.with.details") + System.lineSeparator());
            }
        }
}
