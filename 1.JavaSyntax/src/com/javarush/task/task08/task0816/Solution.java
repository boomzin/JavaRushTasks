package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("JAN 1 2012"));
        map.put("Сталлоне1", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне2", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне3", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне4", dateFormat.parse("JUN 1 2012"));
        map.put("Сталлоне5", dateFormat.parse("JUL 1 2012"));
        map.put("Сталлоне6", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне7", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне8", dateFormat.parse("FEB 1 2012"));
        map.put("Сталлоне9", dateFormat.parse("DEC 1 2012"));

        return map;

        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Iterator<Date> dateIterator=map.values().iterator();
        Calendar calendar= new GregorianCalendar();
        while (dateIterator.hasNext()){
            calendar.setTime(dateIterator.next());
            if (calendar.get(Calendar.MONTH)>=5&&calendar.get(Calendar.MONTH)<=7){
                dateIterator.remove();
            }
        }

        //напишите тут ваш код

    }

    public static void main(String[] args) /*throws ParseException*/ {
//        Map<String,Date> map=createMap();
//        System.out.println(map.size());
//        System.out.println("map.size()");
//        for (String value : map.keySet()) {
//            System.out.println(value);
//        }
//        removeAllSummerPeople(map);
//        System.out.println("map.size()");
//        System.out.println(map.size());
//        System.out.println("dfdfdfdffd");
//        for (String value : map.keySet()) {
//            System.out.println(value);
//        }
    }
}
