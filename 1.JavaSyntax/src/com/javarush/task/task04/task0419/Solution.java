package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());
        int d = Integer.parseInt(bufferedReader.readLine());

        if (a>=b&a>=c&a>=d){
            System.out.println(a);
        }
        else if (b>=c&b>=d){
            System.out.println(b);
        }
        else if (c>=d){
            System.out.println(c);
        }
        else {
            System.out.println(d);
        }


        //напишите тут ваш код

    }
}
