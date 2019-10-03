package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream=System.in;
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader= new BufferedReader(inputStreamReader);

        String s=bufferedReader.readLine();
        int a=Integer.parseInt(s);
        if (a<0){
            System.out.println(a+1);
        }
        else if (a>0){
            System.out.println(a*2);
        }
        else {
            System.out.println(a);
        }
        //напишите тут ваш код

    }

}