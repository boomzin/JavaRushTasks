package com.javarush.task.task26.task2613;

import java.util.*;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode.toUpperCase();
        this.denominations = new TreeMap<>();
    }
    
    public String getCurrencyCode() {
        return currencyCode;
    }



    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
            return;
        }
        denominations.put(denomination, count);
    }
    public boolean hasMoney() {
        
        return !denominations.isEmpty();
    }


    public int getTotalAmount() {
        int total = denominations.entrySet().stream().map(x -> x.getKey() * x.getValue()).reduce(0, (sum, x) -> sum + x);
        return total;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() > expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) {
        Map<Integer, Integer> withdrawAmount = new TreeMap<>(Collections.reverseOrder());
        int change = 0;
        List<Integer> descendingDenominations = new ArrayList<>(((TreeMap<Integer, Integer>) denominations).descendingKeySet());




        return null;
    }
}
