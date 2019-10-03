package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
 //       int [] num = new int [5];
        ArrayList<Integer> num= new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            num.add(Integer.parseInt(reader.readLine()));
        }
        num.sort(Comparator.naturalOrder());


        for (int i = 0; i < 5 ; i++) {
            System.out.println(num.get(i));
        }



        //напишите тут ваш код
    }
}
