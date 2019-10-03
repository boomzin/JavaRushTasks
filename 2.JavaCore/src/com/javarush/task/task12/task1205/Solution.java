package com.javarush.task.task12.task1205;

/* 
Определимся с животным
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String,String> map=new HashMap<>();

    public static void main(String[] args) {
        map.put("Cow","Корова");
        map.put("Dog","Собака");
        map.put("Whale","Кит");
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Dog()));
        System.out.println(getObjectType(new Whale()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        Class class1=o.getClass();
        String nm = class1.getSimpleName();
        if (map.containsKey(nm)){
            return map.get(nm);
        }
        //Напишите тут ваше решение

        return "Неизвестное животное";
    }

    public static class Cow {
    }

    public static class Dog {
    }

    public static class Whale {
    }

    public static class Pig {
    }
}
