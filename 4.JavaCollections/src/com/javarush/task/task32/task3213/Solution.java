package com.javarush.task.task32.task3213;

import java.io.*;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
//        StringReader reader = new StringReader(null);
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        String result = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(reader);
            result = bufferedReader.readLine();
            byte[] bytes = result.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] += key;
            }
            result = new String(bytes);
        } catch (Exception e) {
            result = "";
        }
        return result;
    }
}
