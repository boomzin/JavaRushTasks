package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int sum=0;
        String s;
        while (true){
            s=bufferedReader.readLine();
            if (s.equals("сумма")){
                break;
            }
            sum=sum+Integer.parseInt(s);
        }
        System.out.println(sum);


        //напишите тут ваш код
    }
}
