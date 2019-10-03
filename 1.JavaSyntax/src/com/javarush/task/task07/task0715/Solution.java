package com.javarush.task.task07.task0715;

import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("мама");
        arrayList.add("мыла");
        arrayList.add("раму");
        for (int i = 1; i <=arrayList.size() ; i+=2) {
            arrayList.add(i,"именно");
        }
        for (String s: arrayList) {
            System.out.println(s);
        }
        //напишите тут ваш код
    }
}
