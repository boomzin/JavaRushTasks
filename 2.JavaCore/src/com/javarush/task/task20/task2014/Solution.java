package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        System.out.println(new Solution(4));
        File file = new File("d:\\1.txt");
        try {
            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(file));
            ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(file));
            Solution savedObject = new Solution(5);
            System.out.println(savedObject);
            objectOut.writeObject(savedObject);
            objectOut.close();
            Solution loadedObject = new Solution(7);
            System.out.println(loadedObject);
            loadedObject = (Solution) objectIn.readObject();
            objectIn.close();
            System.out.println(loadedObject);
            System.out.println(savedObject.toString().equals(loadedObject.toString()));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

//    public String getString() {
//        return string;
//    }

    @Override
    public String toString() {
        return this.string;
    }
}
