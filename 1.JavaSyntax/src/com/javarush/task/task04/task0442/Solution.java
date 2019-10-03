package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count=0;
        while (true){
            int n = Integer.parseInt(bufferedReader.readLine());
            if (n==-1){
                count=count+n;
                System.out.println(count);
                break;
            }
            else {
                count=count+n;
            }
        }

        //напишите тут ваш код

    }
}
