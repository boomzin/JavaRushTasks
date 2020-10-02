package com.javarush.task.task35.task3509;


import java.util.*;

/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T>  ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> tArrayList = new ArrayList<>();
//        for (int i = 0; i < elements.length; i++) {
//            arrayList.add(elements[i]);
//        }
        tArrayList.addAll(Arrays.asList(elements));
        //напишите тут ваш код
        return tArrayList;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> tHashSet = new HashSet<>();
        tHashSet.addAll(Arrays.asList(elements));
        //напишите тут ваш код
        return tHashSet;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> key, List <?extends V> value) {
        if (key.size() != value.size()) {
            throw new IllegalArgumentException();
        }
        HashMap<K, V> kvHashMap = new HashMap<>();
        for (int i = 0; i < key.size(); i++) {
            kvHashMap.put(key.get(i), value.get(i));
        }
        //напишите тут ваш код
        return kvHashMap;
    }
}
