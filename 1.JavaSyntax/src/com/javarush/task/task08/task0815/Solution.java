package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String,String> map=new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("lastname"+i,"name"+i);
        }
        return map;
        //напишите тут ваш код

    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int count=0;
        for (String s : map.values()) {
            if (s.equals(name)){
                count++;
            }
        }
        return count;
        //напишите тут ваш код

    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int count=0;
        for (String s : map.keySet()) {
            if (s.equals(lastName)){
                count++;
            }
        }
        return count;
        //напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}
