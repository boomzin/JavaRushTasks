package com.javarush.task.task39.task3913;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        String string = "127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK";
        String string1 = "127.0.0.1\tAmigo\t30.08.2022 16:08:13\tLOGIN\tOK";
        List<String> stringList = new ArrayList<>();
        Date toDay = new Date();

        stringList.add(string);
        stringList.add(string1);
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Long foundDate = null;
        Stream<String> stringStream = stringList.stream();
        Stream stt = stringStream.filter( x -> {
            try {
                return format.parse(x.split("\t")[2]).getTime() <= toDay.getTime();
            } catch (ParseException e) {
                e.printStackTrace();
                return false;
            }
        });
        stt.forEach(System.out::println);
    }
}
