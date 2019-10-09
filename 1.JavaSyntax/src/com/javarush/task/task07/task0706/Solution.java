package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int [] ints =new int[15];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <15 ; i++) {
            ints[i]=Integer.parseInt(bufferedReader.readLine());
        }
        int odd=0;
        int even=0;
        for (int i = 0; i <15 ; i++) {
            if (i%2==0){
                even=even+ints[i];
            }
            else {
                odd=odd+ints[i];
            }
        }
        if (even>odd){
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }
        else {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        }
        //напишите тут ваш код
    }
}
