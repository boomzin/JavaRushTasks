package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> a= new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            a.add(bufferedReader.readLine());
        }
        a.remove(2);
        for (int i = 0; i <a.size() ; i++) {
            System.out.println(a.get(a.size()-i-1));
        }
        //напишите тут ваш код
    }
}
