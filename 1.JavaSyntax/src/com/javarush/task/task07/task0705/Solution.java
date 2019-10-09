package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] ints =new int[20];
        int[] sints =new int[10];
        int[] bints =new int[10];
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <20 ; i++) {
            ints[i]=Integer.parseInt(bufferedReader.readLine());
        }
        for (int i = 0; i <20 ; i++) {
            if (i<(ints.length/2)){
                sints[i]=ints[i];
            }
            else {
                bints[i-ints.length/2]=ints[i];
            }
        }
        for (int i = 0; i <10 ; i++) {
            System.out.println(bints[i]);
        }
        //напишите тут ваш код
    }
}
