package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            String [] nameDate = line.split(" ");
            int year = Integer.parseInt(nameDate[nameDate.length - 1]);
            int month = Integer.parseInt(nameDate[nameDate.length - 2]);
            int day = Integer.parseInt(nameDate[nameDate.length -3]);
            Calendar personDate = new GregorianCalendar();
            personDate.clear();
            personDate.set(Calendar.DAY_OF_MONTH, day);
            personDate.set(Calendar.MONTH, month - 1);
            personDate.set(Calendar.YEAR, year);
            String name = line.substring(0, line.indexOf(nameDate[nameDate.length - 3]) - 1);
            PEOPLE.add(new Person(name, personDate.getTime()));
        }
        fileReader.close();
        bufferedReader.close();

    }
}
