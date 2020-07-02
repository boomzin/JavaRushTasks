package com.javarush.task.task32.task3204;


import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        while (true) {
            StringBuilder stringBuilder = new StringBuilder();
            boolean upperCase = false;
            boolean lowCase = false;
            boolean digit = false;
            char symbol;
            for (int i = 0; i < 8; i++) {
                symbol = (char) (Math.random() * 127);
                if (Character.isUpperCase(symbol)) {
                    upperCase = true;
                    stringBuilder.append(symbol);
                } else if (Character.isLowerCase(symbol)) {
                    lowCase = true;
                    stringBuilder.append(symbol);
                } else if (Character.isDigit(symbol)) {
                    digit = true;
                    stringBuilder.append(symbol);
                }
            }
            if (upperCase && lowCase && digit && stringBuilder.length() == 8) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                baos.write(stringBuilder.toString().getBytes());
                return baos;
            }
        }
    }
}