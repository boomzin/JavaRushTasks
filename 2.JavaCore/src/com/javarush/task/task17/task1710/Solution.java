package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String commandLine = null;
//        try {
//            commandLine = bufferedReader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String [] param = args;
//        param = commandLine.split(" ");

        if ("-c".equals(param[0])) {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date birthDate = null;
            try {
                birthDate = df.parse(param[3]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if ("м".equals(param[2])) {
                allPeople.add(Person.createMale(param[1], birthDate));
            } else {
                allPeople.add(Person.createFemale(param[1], birthDate));
            }
            System.out.println(allPeople.lastIndexOf(allPeople.get(allPeople.size() - 1)));
        }
        if ("-u".equals(param[0])) {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date birthDate = null;
            try {
                birthDate = df.parse(param[4]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int index = Integer.parseInt(param[1]);

            allPeople.get(index).setName(param[2]);
            if ("м".equals(param[3])) {
                allPeople.get(index).setSex(Sex.MALE);
            } else {
                allPeople.get(index).setSex(Sex.FEMALE);
            }
            allPeople.get(index).setBirthDate(birthDate);

        }

        if ("-d".equals(param[0])) {
            int index = Integer.parseInt(param[1]);
            allPeople.get(index).setName(null);
            allPeople.get(index).setSex(null);
            allPeople.get(index).setBirthDate(null);
        }

        if ("-i".equals(param[0])) {
            int index = Integer.parseInt(param[1]);
            System.out.print(allPeople.get(index).getName() + " ");
            if (allPeople.get(index).getSex().equals(Sex.MALE)) {
                System.out.print("м ");
            } else {
                System.out.print("ж ");
            }
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.print(dateFormat.format(allPeople.get(index).getBirthDate()));
        }
        //start here - начни тут
    }
}
