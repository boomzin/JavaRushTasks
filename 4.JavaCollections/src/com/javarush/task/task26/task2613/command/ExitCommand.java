package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

class ExitCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Are your sure? <y,n>: ");
        if ("y".equals(ConsoleHelper.readString().toLowerCase())) {
            ConsoleHelper.writeMessage("GoodBye");
        }
    }
}
