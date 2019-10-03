package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        char[] chars=string.toCharArray();
        for (int i = 0; i < string.length(); i++) {
            if (!Character.isWhitespace(chars[i])&&i==0){
                chars[i]=Character.toUpperCase(chars[i]);
            }
            if (Character.isWhitespace(chars[i])&&i+1<string.length()&&!Character.isWhitespace(chars[i+1])){
                chars[i+1]=Character.toUpperCase(chars[i+1]);
            }
        }
        string=String.copyValueOf(chars);
        System.out.println(string);

        //напишите тут ваш код
    }
}
