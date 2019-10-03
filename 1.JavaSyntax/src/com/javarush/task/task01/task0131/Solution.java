package com.javarush.task.task01.task0131;

/* 
Полнометражная картина
*/

public class Solution {
    public static void main(String[] args) {

        System.out.println(getMetreFromCentimetre(243));
    }

    public static int getMetreFromCentimetre(int centimetre) {
        //centimetre=243;
        int m = centimetre/100;
        //System.out.println(m);
        return m;
        //напишите тут ваш код
    }
}