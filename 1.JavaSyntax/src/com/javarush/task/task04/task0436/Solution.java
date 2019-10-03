package com.javarush.task.task04.task0436;

/* 
Рисуем прямоугольник
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bufferedReader.readLine());
        int y = Integer.parseInt(bufferedReader.readLine());
        for (int i=1; i<=x;i++){
            for (int j=1;j<=y;j++){
                System.out.print("8");
            }
            System.out.println();
        }

        //напишите тут ваш код

    }
}
