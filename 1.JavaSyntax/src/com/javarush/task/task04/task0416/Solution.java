package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader (inputStreamReader);

        double a = Double.parseDouble(bufferedReader.readLine());
        int t=(int) a%5;
        if (t>=0&&t<3){
            System.out.println("зелёный");
        }
        else if (t>=3&t<4){
            System.out.println("жёлтый");
        }
        else if (t>=4){
            System.out.println("красный");
        }
        //напишите тут ваш код

    }
}