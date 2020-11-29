package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        String[] strings = s.toUpperCase().split("");
        int result = map.get(strings[strings.length - 1]);
        int previousDigit = result;
        for (int i = strings.length - 2; i >= 0; i--) {
            if (map.get(strings[i]) >= previousDigit) {
                previousDigit = map.get(strings[i]);
                result += previousDigit;
            } else {
                previousDigit = map.get(strings[i]);
                result -= previousDigit;
            }
        }
        return result;
    }
}
