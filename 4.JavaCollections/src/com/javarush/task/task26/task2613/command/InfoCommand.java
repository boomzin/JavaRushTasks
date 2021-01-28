package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.Collection;

class InfoCommand implements Command {
    @Override
    public void execute() {

        Collection<CurrencyManipulator> manipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        boolean moneyIsExist = false;
        for (CurrencyManipulator manipulator : manipulators) {
            if (manipulator.hasMoney()) {
                moneyIsExist = true;
                System.out.println(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
            }
        }
        if (!moneyIsExist) {
            System.out.println("No money available.");
        }
    }
}
