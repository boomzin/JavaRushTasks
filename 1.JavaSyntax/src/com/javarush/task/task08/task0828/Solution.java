package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String month=reader.readLine();
        ArrayList<String> months=new ArrayList<>(Arrays.asList("January","February","March","April","May","June","July","August","September","October","November","December"));
        for (int i = 0; i < months.size(); i++) {
            if(months.get(i).equals(month)){
                System.out.println(month+" is the "+(i+1)+" month");
            }
        }
        //напишите тут ваш код
    }
}
