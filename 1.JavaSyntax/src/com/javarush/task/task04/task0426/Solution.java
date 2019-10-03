package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        String s ="ноль";
        if (a>0){
            s="положительное";
        }
        else if (a<0){
            s="отрицательное";
        }
        if ((a!=0)&(a%2==0)){
            s=s+" четное число";
        }
        else if (a!=0){
            s=s+" нечетное число";
        }
        System.out.println(s);

        //напишите тут ваш код

    }
}
