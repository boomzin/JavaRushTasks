package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String tmp = bufferedReader.readLine();
        while (!tmp.equals("exit")) {

            try {
                if (tmp.contains(".")) {
                    print(Double.parseDouble(tmp));
                } else if (Integer.parseInt(tmp) > 0 && Integer.parseInt(tmp) < 128) {
                    print(Short.parseShort(tmp));
                } else if (Integer.parseInt(tmp) <= 0 || Integer.parseInt(tmp) >= 128) {
                    print(Integer.parseInt(tmp));
                }
            }
            catch (NumberFormatException e) {
                print(tmp);

            }
            tmp = bufferedReader.readLine();
        }
        //напиште тут ваш код
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
