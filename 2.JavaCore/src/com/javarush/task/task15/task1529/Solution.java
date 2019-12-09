package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        reset();
        //add your code here - добавьте код тут
    }

    public static CanFly result;

    public static void reset() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String flyingObject = bufferedReader.readLine();
            if (flyingObject.equals("helicopter")){
                result = new Helicopter();
            }
            else if (flyingObject.equals("plane")){
                int peopleAmount = Integer.parseInt(bufferedReader.readLine());
                result = new Plane(peopleAmount);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //add your code here - добавьте код тут
    }
}
