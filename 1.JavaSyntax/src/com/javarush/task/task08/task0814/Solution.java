package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        Set<Integer> integers=new HashSet<>();
        for (int i = 0; i < 20; i++) {
            integers.add(i);
        }
        return integers;
        // напишите тут ваш код

    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        Iterator<Integer> integerIterator= set.iterator();
        while (integerIterator.hasNext()){
            if (integerIterator.next()>10){
                integerIterator.remove();
            }
        }



        return set;
        // напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}
