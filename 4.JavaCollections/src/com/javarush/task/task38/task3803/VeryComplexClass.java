package com.javarush.task.task38.task3803;


/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object object = new Object();
        String s = (String) object;
    }

    public void methodThrowsNullPointerException() {
        String[] strings = new String[5];
        System.out.println(strings[3].equals("_"));
    }

    public static void main(String[] args) {
        VeryComplexClass veryComplexClass = new VeryComplexClass();
        veryComplexClass.methodThrowsNullPointerException();
        veryComplexClass.methodThrowsClassCastException();
    }
}
