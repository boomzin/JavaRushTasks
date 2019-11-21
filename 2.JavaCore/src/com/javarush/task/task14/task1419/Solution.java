package com.javarush.task.task14.task1419;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        String s=null;
        try {
            System.out.println(s.length());
        } catch (Exception e) {
            exceptions.add(e);
        }
        s="1s";
        try {
            char c = s.charAt(3);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int a = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }
        try {
            exceptions.get(5);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            FileReader fileReader = new FileReader("dvsd");
        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }
        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            throw new ClassCastException();
        } catch (ClassCastException e) {
            exceptions.add(e);
        }
        try {
            throw new ClassNotFoundException();
        } catch (ClassNotFoundException e) {
            exceptions.add(e);
        }
        try {
            throw new InterruptedException();
        } catch (InterruptedException e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }
}
