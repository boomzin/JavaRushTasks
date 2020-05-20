package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greeting;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("first", "Last", "RU", Sex.FEMALE);
        System.out.println(person.firstName);
        System.out.println(person.lastName);
        System.out.println(person.fullName);
        System.out.println(person.country);
        System.out.println(person.sex);
        System.out.println();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\1.txt"));
        oos.writeObject(person);
        oos.flush();
        oos.close();

        Person newPerson = new Person("nfirst", "nLast", "UA", Sex.MALE);
        System.out.println(newPerson.firstName);
        System.out.println(newPerson.lastName);
        System.out.println(newPerson.fullName);
        System.out.println(newPerson.country);
        System.out.println(newPerson.sex);
        System.out.println(newPerson.logger);
        System.out.println();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\1.txt"));
        newPerson = (Person) ois.readObject();
        System.out.println(newPerson.firstName);
        System.out.println(newPerson.lastName);
        System.out.println(newPerson.fullName);
        System.out.println(newPerson.greeting);
        System.out.println(newPerson.country);
        System.out.println(newPerson.sex);

    }
}
