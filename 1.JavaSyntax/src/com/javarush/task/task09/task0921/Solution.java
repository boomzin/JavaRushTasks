package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> numbers=new ArrayList<>();
        boolean toggleSwitch=true;
        while (toggleSwitch==true){
            try {
                numbers.add(Integer.parseInt(bufferedReader.readLine()));
            } catch (Exception e) {
                for (int i = 0; i < numbers.size() ; i++) {
                    System.out.println(numbers.get(i));
                }
                toggleSwitch=false;
            }
        }
        //напишите тут ваш код
    }
}
