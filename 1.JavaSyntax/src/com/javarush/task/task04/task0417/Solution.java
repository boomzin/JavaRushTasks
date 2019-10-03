package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream=System.in;
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        int a= Integer.parseInt(bufferedReader.readLine());
        int b= Integer.parseInt(bufferedReader.readLine());
        int c= Integer.parseInt(bufferedReader.readLine());

        if (a==b){
            System.out.print(a+" ");
            System.out.print(b);
            if (a==c){
                System.out.print(" "+c);
            }
        }
        else if (b==c){
            System.out.print(b+" ");
            System.out.print(c);
        }
        else if (a==c){
            System.out.print(a+" ");
            System.out.print(c);
        }

        //напишите тут ваш код

    }
}