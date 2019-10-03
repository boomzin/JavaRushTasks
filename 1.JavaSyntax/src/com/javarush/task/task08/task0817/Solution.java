package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {

    public static Map<String, String> createMap() {
        Map<String,String> people=new HashMap<>();
        people.put("lastname1","name1");
        people.put("lastname2","name1");
        people.put("lastname3","name2");
        people.put("lastname4","name3");
        people.put("lastname5","name4");
        people.put("lastname6","name5");
        people.put("lastname7","name6");
        people.put("lastname8","name6");
        people.put("lastname9","name8");
        people.put("lastname0","name9");
        return people;
        //напишите тут ваш код

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Iterator<String> lastname = map.keySet().iterator();
        ArrayList<String> dubl=new ArrayList<>();
        String tmpKey;
        while (lastname.hasNext()){
            tmpKey=lastname.next();
            Map<String,String> copy=new HashMap<>(map);
            copy.remove(tmpKey);
            if (copy.containsValue(map.get(tmpKey))&&!dubl.contains(map.get(tmpKey))){
                dubl.add(map.get(tmpKey));
            }
        }
        for (int i = 0; i < dubl.size(); i++) {
            removeItemFromMapByValue(map,dubl.get(i));
        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
//        Map<String,String> tmp= createMap();
//        System.out.println(tmp.size());
//        System.out.println(tmp.entrySet());
//        removeTheFirstNameDuplicates(tmp);
//        System.out.println(tmp.size());
//        System.out.println(tmp.entrySet());

    }
}
