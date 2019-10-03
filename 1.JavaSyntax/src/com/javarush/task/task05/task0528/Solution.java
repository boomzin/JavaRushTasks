package com.javarush.task.task05.task0528;

/* 
Вывести на экран сегодняшнюю дату
*/

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Solution {
    public static void main(String[] args) {
        Calendar calendar= new GregorianCalendar();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd MM yyyy");
        System.out.println(simpleDateFormat.format(calendar.getTime()));

        //напишите тут ваш код
    }
}
