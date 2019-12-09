package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String url="";
        try {
            url = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = url.substring(url.indexOf('?')+1);
        ArrayList<String> valueParam = new ArrayList<>();
        String[] param = url.split("&");
        for (String s : param) {
            if (s.contains("=")){
                System.out.print(s.substring(0,s.indexOf('=')) + " ");
                if (s.substring(0,s.indexOf('=')).equals("obj")){
                    valueParam.add(s.substring(s.indexOf('=')+1));
                }
            } else {
                System.out.print(s + " ");
            }
        }
        if (!valueParam.isEmpty()) {
            System.out.println("");
            for (String s :
                    valueParam) {
                try {
                    Double doubleValue = Double.parseDouble(s);
                    alert(doubleValue);
                } catch (NumberFormatException e) {
                    alert(s);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
