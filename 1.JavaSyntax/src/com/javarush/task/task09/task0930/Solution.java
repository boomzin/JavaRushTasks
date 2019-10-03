package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        ArrayList<Integer> numbers=new ArrayList();
        ArrayList<Integer> numbersPosition=new ArrayList<>();
        ArrayList<String> strings=new ArrayList<>();
        ArrayList<Integer> stringsPosition=new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])){
                numbers.add(Integer.parseInt(array[i]));
                numbersPosition.add(i);
            }
            else {
                strings.add(array[i]);
                stringsPosition.add(i);
            }
        }
//        Collections.sort(strings);
        for (int i = strings.size()-1; i >=1; i--) {
            for (int j = 0; j <i; j++) {
                if (isGreaterThan(strings.get(j),strings.get(j+1))){
                    String tmp=strings.get(j);
                    strings.set(j,strings.get(j+1));
                    strings.set(j+1,tmp);
                }
            }
        }
//        for (String string : strings) {
//            System.out.println(string);
//        }
        Collections.sort(numbers);
        for (int i = 0; i < numbers.size() / 2; i++) {
            int tmp=numbers.get(i);
            numbers.set(i,numbers.get(numbers.size()-i-1));
            numbers.set(numbers.size()-i-1,tmp);
        }
        for (int i = 0; i < numbers.size(); i++) {
            array[numbersPosition.get(i)]=numbers.get(i).toString();
        }
        for (int i = 0; i < strings.size(); i++) {
            array[stringsPosition.get(i)]=strings.get(i);
        }

        // напишите тут ваш код
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
