package com.javarush.task.task26.task2613;

public enum Operation {
    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;
    public static Operation getAllowableOperationByOrdinal(Integer i) {
        if (i > 4 || i < 1) {
            throw new IllegalArgumentException();
        }
        switch (i) {
            case 1: return Operation.INFO;
            case 2: return Operation.DEPOSIT;
            case 3: return Operation.WITHDRAW;
            default: return Operation.EXIT;
        }

    }


}
