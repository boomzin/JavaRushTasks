package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        ArrayList<Character> vowelsString=new ArrayList<>();
        ArrayList<Character> otherSymbolsString = new ArrayList<>();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String s=bufferedReader.readLine();
        s=s.replaceAll(" ","");
        for (int i=0;i<s.length();i++) {
            if (!isVowel(s.charAt(i))){
                otherSymbolsString.add(s.charAt(i));
            }
            else {
                vowelsString.add(s.charAt(i));
            }
        }

        for (int i = 0; i < vowelsString.size(); i++) {
            System.out.print(vowelsString.get(i)+" ");
        }
        System.out.println();
        for (int i = 0; i < otherSymbolsString.size(); i++) {
            System.out.print(otherSymbolsString.get(i)+" ");
        }
        //напишите тут ваш код
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}