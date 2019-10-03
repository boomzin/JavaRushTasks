package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,String> list = new HashMap<String,String>();
        while (true) {
            String city =reader.readLine();
            if (city.isEmpty()) {
                break;
            }
            String family = reader.readLine();
//            if (family.isEmpty()) {
//                break;
//            }


            list.put(city,family);
        }

        // Read the house number
//        int houseNumber = Integer.parseInt(reader.readLine());
        String searchCity=reader.readLine();

//        if (0 <= houseNumber && houseNumber < list.size()) {
//            String familyName = list.get(houseNumber);
            System.out.println(list.get(searchCity));
//        }
    }
}
