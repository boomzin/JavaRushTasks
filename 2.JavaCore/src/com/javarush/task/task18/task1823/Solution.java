package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader  bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String fileName = bufferedReader.readLine();
            if ("exit".equals(fileName)) {
                break;
            }
            Thread bytesCounting = new ReadThread(fileName);
            bytesCounting.start();
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
            //implement constructor body
        }

        @Override
        public void run() {
            int [] frequency = new int[256];
            try {
                FileInputStream reader = new FileInputStream(fileName);
                byte[] bytes = new byte[reader.available()];
                reader.read(bytes);
                for (int i = 0; i < bytes.length; i++) {
                    frequency[bytes[i]]++;
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int maxCount = 0;
            int maxIndex = 0;
            for (int i = 0; i < frequency.length; i++) {
                if (frequency[i] > maxCount) {
                    maxCount = frequency[i];
                    maxIndex = i;
                }
            }
            synchronized (resultMap) {
                resultMap.put(fileName, maxIndex);
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
