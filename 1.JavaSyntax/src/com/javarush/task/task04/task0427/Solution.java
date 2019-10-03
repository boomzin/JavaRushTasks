package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());

        if (a<1||a>999){
            return;
        }

        String s;
        if ((a%2)==0) {
            s="четное";
        }
        else  {
            s="нечетное";
        }
        String l=Integer.toString(a);
        if (l.length()==1){
            s=s+ " однозначное число";
        }
        else if (l.length()==2){
            s=s+" двузначное число";
        }
        else {
            s=s+" трехзначное число";
        }
        System.out.println(s);


        //напишите тут ваш код

    }
}
