package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;
//import java.util.*;
//import java.util.function.IntPredicate;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream=System.in;
        InputStreamReader inputStreamReader= new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String day = bufferedReader.readLine();
        if (day.equals("1")){
            System.out.println("понедельник");
        }
        else if (day.equals("2")){
            System.out.println("вторник");
        }
        else if (day.equals("3")){
            System.out.println("среда");
        }
        else if (day.equals("4")){
            System.out.println("четверг");
        }
        else if (day.equals("5")){
            System.out.println("пятница");
        }
        else if (day.equals("6")){
            System.out.println("суббота");
        }
        else if (day.equals("7")){
            System.out.println("воскресенье");
        }
        else {
            System.out.println("такого дня недели не существует");
        }


        //напишите тут ваш код

    }
}