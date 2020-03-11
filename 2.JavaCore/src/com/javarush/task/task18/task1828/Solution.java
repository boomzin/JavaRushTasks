package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedFileReader = new BufferedReader(fileReader);
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        int iD = Integer.parseInt(args[1]);
        while (!((line = bufferedFileReader.readLine()) == null)) {
            if (iD == Integer.parseInt(line.substring(0, 8).trim())) {
                if ("-d".equals(args[0])) {
                    break;
                } else if ("-u".equals(args[0])) {
                    String productName = String.format("%-30s", args[2]);
                    String price = String.format("%-8s", args[3]);
                    String quantity = String.format("%-4s", args[4]);
                    String changedLine = line.substring(0, 8) + productName + price + quantity + System.lineSeparator();
                    stringBuffer.append(changedLine);
                    break;
                }
            }
            stringBuffer.append(line + System.lineSeparator());
        }
        while (!((line = bufferedFileReader.readLine()) == null)){
            stringBuffer.append(line + System.lineSeparator());
        }
        bufferedFileReader.close();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        bufferedWriter.write(stringBuffer.toString());
        bufferedWriter.close();
    }
}
