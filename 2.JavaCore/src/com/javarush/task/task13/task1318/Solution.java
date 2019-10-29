package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String path=bufferedReader.readLine();
        InputStream inputStream= new FileInputStream(path);
        while (inputStream.available()>0){
            System.out.print((char) inputStream.read());
        }
        bufferedReader.close();
        inputStream.close();
        // напишите тут ваш код
    }
}