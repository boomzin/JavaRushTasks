package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String,String> map = new HashMap<>();
        map.put("lastname","firstname");
        map.put("lastname","firstname1");
        map.put("lastname1","firstname2");
        map.put("lastname1","firstname3");
        map.put("lastname2","firstname4");
        map.put("lastname3","firstname4");
        map.put("lastname4","firstname5");
        map.put("lastname5","firstname6");
        map.put("lastname6","firstname7");
        map.put("lastname7","firstname8");
        //напишите тут ваш код

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
