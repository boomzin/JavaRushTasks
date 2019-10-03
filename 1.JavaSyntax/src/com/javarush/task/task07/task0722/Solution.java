package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arrayList= new ArrayList<>();
        String br;
        while (true){
            br=reader.readLine();
            if (br.equals("end")){
                break;
            }
            arrayList.add(br);
        }
        for (String s : arrayList) {
            System.out.println(s);
        }

        //напишите тут ваш код
    }
}