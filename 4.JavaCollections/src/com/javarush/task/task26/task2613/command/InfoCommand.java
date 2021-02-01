package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.ResourceBundle;

class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");
    @Override
    public void execute() {
        System.out.println(res.getString("before"));
        Collection<CurrencyManipulator> manipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        boolean moneyIsExist = false;
        for (CurrencyManipulator manipulator : manipulators) {
            if (manipulator.hasMoney()) {
                moneyIsExist = true;
                System.out.println(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
            }
        }
        if (!moneyIsExist) {
            System.out.println(res.getString("no.money"));
        }
    }
}
