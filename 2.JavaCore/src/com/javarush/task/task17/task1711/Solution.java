package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    createPersons(args);
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    updatePersons(args);
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    deletePersons(args);
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    printPersons(args);
                }
                break;
            default:
                synchronized (allPeople) {}
                break;
        }
    }

    public static void createPersons(String[] param) {
        for (int i = 0; i < param.length / 3; i++) {
            String name = param[i * 3 + 1];
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date birthDate = null;
            try {
                birthDate = dateFormat.parse(param[i * 3 + 3]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            switch (param[i * 3 + 2]) {
                case "м":
                    allPeople.add(Person.createMale(name, birthDate));
                    break;
                case "ж":
                    allPeople.add(Person.createFemale(name, birthDate));
                    break;
            }
            System.out.println(allPeople.size() - 1);
//            System.out.println(allPeople.get(allPeople.size() - 1).getName());
//            System.out.println(allPeople.get(allPeople.size() - 1).getSex());
//            System.out.println(allPeople.get(allPeople.size() - 1).getBirthDate());
        }
    }

    public static void updatePersons(String[] param) {
        for (int i = 0; i < param.length / 4; i++) {
            int index = Integer.parseInt(param[i * 4 + 1]);
            String name = param[i * 4 + 2];
            Sex sex = null;
            switch (param[i * 4 + 3]) {
                case "м":
                    sex = Sex.MALE;
                    break;
                case "ж":
                    sex = Sex.FEMALE;
                    break;
            }
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date birthDate = null;
            try {
                birthDate = dateFormat.parse(param[i * 4 + 4]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

//            System.out.print(index);
//            System.out.print(allPeople.get(index).getName());
//            System.out.print(allPeople.get(index).getSex());
//            System.out.println(allPeople.get(index).getBirthDate());

            allPeople.get(index).setName(name);
            allPeople.get(index).setSex(sex);
            allPeople.get(index).setBirthDate(birthDate);

//            System.out.print(index);
//            System.out.print(allPeople.get(index).getName());
//            System.out.print(allPeople.get(index).getSex());
//            System.out.println(allPeople.get(index).getBirthDate());

        }
    }
    public static void deletePersons(String[] param) {
        for (int i = 1; i < param.length; i++) {
            int index = Integer.parseInt(param[i]);

//            System.out.print(index);
//            System.out.print(allPeople.get(index).getName());
//            System.out.print(allPeople.get(index).getSex());
//            System.out.println(allPeople.get(index).getBirthDate());

            allPeople.get(index).setName(null);
            allPeople.get(index).setSex(null);
            allPeople.get(index).setBirthDate(null);

//            System.out.print(index);
//            System.out.print(allPeople.get(index).getName());
//            System.out.print(allPeople.get(index).getSex());
//            System.out.println(allPeople.get(index).getBirthDate());
        }
    }
    public static void printPersons(String[] param) {
        for (int i = 1; i < param.length; i++) {
            int index = Integer.parseInt(param[i]);
            String sex = null;
            if (Sex.MALE.equals(allPeople.get(index).getSex())) {
                sex = "м";
            } else {
                sex = "ж";
            }
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.print(allPeople.get(index).getName() + " ");
            System.out.print(sex + " ");
            System.out.println(dateFormat.format(allPeople.get(index).getBirthDate()));

        }
    }

}
