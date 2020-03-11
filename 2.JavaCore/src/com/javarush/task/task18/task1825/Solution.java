package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String> numberFileName = new TreeMap<>();
        while (true) {
            String fileName = bufferedReader.readLine();
            if ("end".equals(fileName)) {
                break;
            }
            numberFileName.put(Integer.parseInt(fileName.substring(fileName.lastIndexOf(".part") + 5)), fileName);
        }
        bufferedReader.close();
        File resultFile = new File(numberFileName.get(1).substring(0, numberFileName.get(1).lastIndexOf(".part")));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(resultFile));
        for (Map.Entry<Integer, String > item:
             numberFileName.entrySet()) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(item.getValue()));
            byte[] buff = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(buff);
            bufferedOutputStream.write(buff);
            bufferedInputStream.close();
        }
        bufferedOutputStream.close();
    }

}
