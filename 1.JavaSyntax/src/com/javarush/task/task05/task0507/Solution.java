package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        int b=0;
        int sum=0;
        int count=0;

        while (true){
            b=Integer.parseInt(bufferedReader.readLine());
            if (b==-1&&count!=0){
                double s=(double) sum/count;
                System.out.println(s);
                break;
            }
            else if (b==-1&&count==0){
                System.out.println(0);
                break;
            }
            sum=sum+b;
            count++;

        }

        //напишите тут ваш код
    }
}

