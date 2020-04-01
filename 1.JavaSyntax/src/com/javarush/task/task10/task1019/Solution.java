package com.javarush.task.task10.task1019;

//import sun.security.pkcs.ParsingException;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> map= new HashMap<>();
        while (true){
            try {
                int id = Integer.parseInt(reader.readLine());
                String name = reader.readLine();
                map.put(name,id);
            }
            catch (NumberFormatException e){
                break;
            }
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            System.out.println(stringIntegerEntry.getValue()+" "+stringIntegerEntry.getKey());
        }

//        System.out.println("Id=" + id + " Name=" + name);
    }
}
