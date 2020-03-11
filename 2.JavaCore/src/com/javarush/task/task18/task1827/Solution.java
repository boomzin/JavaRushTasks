package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        if (!(args.length == 0) && "-c".equals(args[0])) {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader lineReader = new BufferedReader(fileReader);
            String line;
            int maxID = 0;
            while ((line = lineReader.readLine()) != null) {
                String splitLine = line.substring(0, 8).trim();
                if (maxID < Integer.parseInt(splitLine)) {
                    maxID = Integer.parseInt(splitLine);
                }
            }
            lineReader.close();
            StringBuilder newID = new StringBuilder(String.valueOf(maxID + 1));
            newID.setLength(8);
            StringBuilder productName = new StringBuilder(args[1]);
            productName.setLength(30);
            StringBuilder price = new StringBuilder(args[2]);
            price.setLength(8);
            StringBuilder quantity = new StringBuilder(args[3]);
            quantity.setLength(4);
            String newLineIntoDB = newID.toString() + productName + price + quantity;
            String nLDB = newLineIntoDB.replace('\0', ' ');
            PrintStream newDB = new PrintStream(new FileOutputStream(fileName, true));
            newDB.print(System.lineSeparator());
            newDB.print(nLDB);
            newDB.close();
        }
    }
}
