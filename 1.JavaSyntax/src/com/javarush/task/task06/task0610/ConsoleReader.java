package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
        //напишите тут ваш код

    }

    public static int readInt() throws Exception {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(bufferedReader.readLine());
        //напишите тут ваш код

    }

    public static double readDouble() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return Double.parseDouble(bufferedReader.readLine());
        //напишите тут ваш код

    }

    public static boolean readBoolean() throws Exception {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        return Boolean.parseBoolean(bufferedReader.readLine());
        //напишите тут ваш код

    }

    public static void main(String[] args) throws Exception {

    }
}
