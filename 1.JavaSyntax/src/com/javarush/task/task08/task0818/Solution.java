package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String,Integer> map=new HashMap<>();
        map.put("lastname",100);
        map.put("lastname1",200);
        map.put("lastname2",300);
        map.put("lastname3",400);
        map.put("lastname4",500);
        map.put("lastname5",600);
        map.put("lastname6",700);
        map.put("lastname7",800);
        map.put("lastname8",800);
        map.put("lastname9",9900);
        return map;
        //напишите тут ваш код
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
//        Map<> copy
        Iterator<String> stringIterator=map.keySet().iterator();
        String tacky="";
        while (stringIterator.hasNext()){
            tacky = stringIterator.next();
            if (map.get(tacky)<500){
                stringIterator.remove();
            }
        }
        //напишите тут ваш код
    }

    public static void main(String[] args) {
//        Map<String,Integer> map= createMap();
//        System.out.println(map.size());
//        System.out.println(map);
//        System.out.println("");
//        removeItemFromMap(map);
//        System.out.println(map.size());
//        System.out.println(map);

    }
}