package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        ArrayList<String> mstring=new ArrayList<>();
        strings=new ArrayList<>();
        int mcount=0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <5 ; i++) {
            strings.add(bufferedReader.readLine());
        }
        for (int i = 0; i <5 ; i++) {
            if (strings.get(i).length()>mcount){
                mcount=strings.get(i).length();
                mstring.clear();
                mstring.add(strings.get(i));
            }
            else if (strings.get(i).length()==mcount){
                mstring.add(strings.get(i));
            }
        }
        for (String x: mstring){
            System.out.println(x);
        }


        //напишите тут ваш код
    }
}
