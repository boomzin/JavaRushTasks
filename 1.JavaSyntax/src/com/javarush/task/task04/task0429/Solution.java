package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());
        int pc=0;
        int nc=0;
        if (a>0){
            pc++;
        }
        else if (a<0){
            nc++;
        }
        if (b>0){
            pc++;
        }
        else if (b<0){
            nc++;
        }
        if (c>0){
            pc++;
        }
        else if (c<0){
            nc++;
        }
        System.out.println("количество отрицательных чисел: "+nc);
        System.out.println("количество положительных чисел: "+pc);


        //напишите тут ваш код

    }
}
