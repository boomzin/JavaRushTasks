package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        int a= Integer.parseInt(bufferedReader.readLine());
        int b= Integer.parseInt(bufferedReader.readLine());
        int c= Integer.parseInt(bufferedReader.readLine());

        if (a>=b&a>=c){
            if (b>=c){
                System.out.println(a+" "+ b+" "+c);
            }
            else {
                System.out.println(a+" "+ c+" "+b);
            }
        }
        else if (b>=a&b>=c){
            if (a>=c){
                System.out.println(b+" "+a+" "+c);
            }
            else {
                System.out.println(b+" "+c+" "+a);
            }
        }
        else {
            if (a>=b){
                System.out.println(c+" "+a+" "+b);
            }
            else{
                System.out.println(c+" "+b+" "+a);
            }
        }

        //напишите тут ваш код

    }
}
