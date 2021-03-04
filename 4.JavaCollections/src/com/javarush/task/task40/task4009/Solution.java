package com.javarush.task.task40.task4009;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/* 
Buon Compleanno!
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
//        System.out.println(getWeekdayOfBirthday("1.12.2015", "2016"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate localDate = LocalDate.parse(birthday, dateTimeFormatter);
        LocalDate newLocalDate = localDate.plusYears(Year.parse(year).getValue() - localDate.getYear());
        return DateTimeFormatter.ofPattern("EEEE").withLocale(Locale.ITALIAN).format(newLocalDate);
    }
}
