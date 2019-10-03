package com.javarush.task.task08.task0827;

import java.text.Format;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("JANUARY 2 2000"));
    }

    public static boolean isDateOdd(String date) {
        Date date1=new Date(date);
        Calendar calendar =new GregorianCalendar();
        calendar.setTime(date1);
        return calendar.get(Calendar.DAY_OF_YEAR)%2==0?false:true;
    }
}
