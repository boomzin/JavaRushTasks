package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings= new ArrayList<>();
        ArrayList<String> ns= new ArrayList<>();
        BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <5 ; i++) {
            strings.add(bufferedReader.readLine());
        }
        int size=strings.get(0).length();
        for (int i = 0; i <strings.size() ; i++) {
            if (size>strings.get(i).length()){
                size=strings.get(i).length();
                ns.clear();
                ns.add(strings.get(i));
            }
            else if (size==strings.get(i).length()){
                ns.add(strings.get(i));
            }
        }
        for (String s:ns){
            System.out.println(s);
        }
        
        
        //напишите тут ваш код
    }
}
