package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        InputStream inputStream=System.in;
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int a= Integer.parseInt(bufferedReader.readLine());
        int b= Integer.parseInt(bufferedReader.readLine());
        int c= Integer.parseInt(bufferedReader.readLine());

        if ((a<(b+c))&(b<(a+c))&(c<(a+b))){
            System.out.println("Треугольник существует.");
        }
        else {
            System.out.println("Треугольник не существует.");
        }
        //напишите тут ваш код

    }
}