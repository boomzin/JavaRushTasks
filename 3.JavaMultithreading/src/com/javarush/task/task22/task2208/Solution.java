package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String>  params = new HashMap<>();
//        params.put("name", "Ivanov");
//        params.put("city", "Moscow");
        params.put("Street", null);
        params.put("country", null);
        System.out.println(getQuery(params));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (!(entry.getValue() == null)) {
                stringBuilder.append(entry.getKey() +  " = '" + entry.getValue() + "' and ");
            }
        }
        return stringBuilder.length() == 0? "": stringBuilder.toString().substring(0, stringBuilder.length() - 5);
    }
}
