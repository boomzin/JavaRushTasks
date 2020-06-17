package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("d:\\testFile.log"));
//        StringWriter writer = getAllDataFromInputStream(null);
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter stringWriter = new StringWriter();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(is));
        } catch (NullPointerException e) {
            return stringWriter;
        }
        String string;
        while ((string = bufferedReader.readLine())!= null){
            stringWriter.write(string);
        }
        bufferedReader.close();
        return stringWriter;
    }
}