package com.javarush.task.task07.task0712;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add(bufferedReader.readLine());
        }
        int min=strings.get(0).length();
        int max=0;
        int positionmin=0;
        int positionmax=0;
        for (int i = 0; i <strings.size() ; i++) {
            if (min>strings.get(i).length()){
                min=strings.get(i).length();
                positionmin=i;
            }
            if (max<strings.get(i).length()){
                max=strings.get(i).length();
                positionmax=i;
            }
        }
        System.out.println(positionmax>positionmin?strings.get(positionmin):strings.get(positionmax));

        //напишите тут ваш код
    }
}
