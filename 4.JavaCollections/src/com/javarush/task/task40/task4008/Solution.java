package com.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/* 
Работа с Java 8 DateTime API
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        boolean printDate = true;
        boolean printTime = true;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d.M.yyyy H:mm:ss");
        LocalDate localDate = null;
        LocalTime localTime = null;
        if (date.contains(".") && date.contains(":")) {
            localDate = LocalDate.parse(date, dateTimeFormatter);
            localTime = LocalTime.parse(date, dateTimeFormatter);
        }
        if (date.contains(".") && !date.contains(":")) {
            dateTimeFormatter =DateTimeFormatter.ofPattern("d.M.yyyy");
            localDate = LocalDate.parse(date, dateTimeFormatter);
            printTime = false;
        }
        if (date.contains(":") && !date.contains(".")) {
            dateTimeFormatter =DateTimeFormatter.ofPattern("H:mm:ss");
            localTime = LocalTime.parse(date, dateTimeFormatter);
            printDate = false;
        }

        if (printDate) {
            System.out.println("День: " + localDate.getDayOfMonth());
            System.out.println("День недели: " + localDate.getDayOfWeek().getValue());
            System.out.println("День месяца: " + localDate.getDayOfMonth());
            System.out.println("День года: " + localDate.getDayOfYear());
            System.out.println("Неделя месяца: " + DateTimeFormatter.ofPattern("W").format(localDate));
            System.out.println("Неделя года: " + DateTimeFormatter.ofPattern("w").format(localDate));
            System.out.println("Месяц: " + localDate.getMonthValue());
            System.out.println("Год: " + localDate.getYear());
        }
        if (printTime) {
            System.out.println("AM или PM: " + DateTimeFormatter.ofPattern("a").format(localTime));
            System.out.println("Часы: " + DateTimeFormatter.ofPattern("h").format(localTime));
            System.out.println("Часы дня: " + localTime.getHour());
            System.out.println("Минуты: " + localTime.getMinute());
            System.out.println("Секунды: " + localTime.getSecond());
        }
    }
}
