package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> idSet = new HashSet<>();
        for (String string : strings) {
            idSet.add(shortener.getId(string));
        }
        return idSet;
    }
    static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> stringSet = new HashSet<>();
        for (Long key : keys) {
            stringSet.add(shortener.getString(key));
        }
        return stringSet;
    }

    static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> generatedSet = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            generatedSet.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        Date start = new Date();
        Set<Long> strategyIdSet = getIds(shortener, generatedSet);
        Date finish = new Date();
        Long duration = finish.getTime() - start.getTime();
        Helper.printMessage(duration.toString());
        start = new Date();
        Set<String> strategyStringSet = getStrings(shortener, strategyIdSet);
        finish = new Date();
        duration = finish.getTime() - start.getTime();
        Helper.printMessage(duration.toString());
        if (generatedSet.equals(strategyStringSet)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }

    }


    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(), 10000);
        testStrategy(new OurHashMapStorageStrategy(), 10000);
        testStrategy(new OurHashBiMapStorageStrategy(), 10000);
        testStrategy(new HashBiMapStorageStrategy(), 10000);
        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);
        testStrategy(new FileStorageStrategy(), 100);


    }
}
