package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
//        FileReader file = new FileReader("d:\\1.txt");
//        Scanner scanner = new Scanner(file);
//        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(scanner);
//        Person person = personScannerAdapter.read();
//        Date date = person.getBirthDate();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
//        System.out.println(simpleDateFormat.format(date));
//        System.out.println(date.getDate());
//        System.out.println(date.getMonth());
//        System.out.println(date.getYear());

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;
        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String personLine = fileScanner.nextLine();
            String[] personArray = personLine.split(" ");
            Calendar calendar = new GregorianCalendar();
            calendar.clear();
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(personArray[3]));
            calendar.set(Calendar.MONTH, Integer.parseInt(personArray[4]) - 1);
            calendar.set(Calendar.YEAR, Integer.parseInt(personArray[5]));
            Date birthDate = calendar.getTime();
            Person readyPerson = new Person(personArray[1], personArray[2], personArray[0], birthDate);
            return readyPerson;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
