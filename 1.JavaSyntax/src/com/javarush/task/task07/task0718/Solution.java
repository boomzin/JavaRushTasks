package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings= new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            strings.add(bufferedReader.readLine());
        }
        for (int i = 0; i <9 ; i++) {
            if (strings.get(i+1).length()-strings.get(i).length()>1||strings.get(i+1).length()-strings.get(i).length()<0){
                System.out.println(i+2);
                return;
            }
        }
        //напишите тут ваш код
    }
}

