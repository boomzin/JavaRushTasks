package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode.toUpperCase();
        this.denominations = new TreeMap<>();

//        denominations.put(15, 5);
//        denominations.put(25, 5);
//        denominations.put(35, 5);
//        denominations.put(45, 5);
//        denominations.put(55, 5);
//        denominations.put(1, 9);

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

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer, Integer> withdrawAmount = new TreeMap<>(Collections.reverseOrder());
        Map<Integer, Map<Integer, Integer>> allResults = new TreeMap<>();
        int k = 0;
        int remainder = expectedAmount;
        List<Integer> descendingDenominations = new ArrayList<>(((TreeMap<Integer, Integer>) denominations).descendingKeySet());
        while (k < descendingDenominations.size()) {
            for (int i = k; i < descendingDenominations.size(); i++) {
                int count = remainder / descendingDenominations.get(i);
                if (count > 0) {
                    if (count > denominations.get(descendingDenominations.get(i))) {
                        count = denominations.get(descendingDenominations.get(i));
                    }
                    remainder -= count * descendingDenominations.get(i);
                    withdrawAmount.put(descendingDenominations.get(i), count);
                    if (remainder == 0) {
                        break;
                    }
                }
            }
            int withdraw = withdrawAmount.entrySet().stream().map(x -> x.getKey() * x.getValue()).reduce(0, (sum, x) -> sum + x);
            if (withdraw == expectedAmount) {
                int noteCount = withdrawAmount.values().stream().reduce(0, (sum, x) -> sum +x);
                if (!allResults.containsKey(noteCount)) {
                    allResults.put(noteCount, withdrawAmount);
                }
            } else {
                remainder = expectedAmount;
                withdrawAmount.clear();
            }
            k++;
        }
        if (withdrawAmount.size() == 0) {
            throw new NotEnoughMoneyException();
        }
        return withdrawAmount;
    }
}
