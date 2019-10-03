package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyy-MM-dd",Locale.US);
        Date date=simpleDateFormat.parse(bufferedReader.readLine());
        SimpleDateFormat simpleDateFormatNew=new SimpleDateFormat("MMM dd, yyyy",Locale.US);
        System.out.println(simpleDateFormatNew.format(date).toUpperCase());
        //напишите тут ваш код
    }
}
