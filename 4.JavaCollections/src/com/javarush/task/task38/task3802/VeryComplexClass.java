package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("");
        Date date = dateFormat.parse("__");
    }

    public static void main(String[] args) throws Exception {
        VeryComplexClass veryComplexClass = new VeryComplexClass();
        veryComplexClass.veryComplexMethod();
    }
}
