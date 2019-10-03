package com.javarush.task.task08.task0812;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arrayList= new ArrayList<>();
        List<Integer> maxarray= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(Integer.parseInt(bufferedReader.readLine()));
        }
        int maxstring=1;

        for (int i = 0; i < arrayList.size()-1; i++) {
            if (arrayList.get(i).equals(arrayList.get(i+1))){
                maxstring++;
                maxarray.add(maxstring);
            }
            else{
                maxarray.add(maxstring);
                maxstring=1;
            }
        }
        maxarray.sort(Integer::compareTo);
        System.out.println(maxarray.get(maxarray.size()-1));
        //напишите тут ваш код

    }
}