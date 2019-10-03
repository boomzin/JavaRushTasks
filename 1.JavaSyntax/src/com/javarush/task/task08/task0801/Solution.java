package com.javarush.task.task08.task0801;

/* 
Set из растений
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Set<String> eatit = new HashSet<String>();
        eatit.add("арбуз");
        eatit.add("банан");
        eatit.add("вишня");
        eatit.add("груша");
        eatit.add("дыня");
        eatit.add("ежевика");
        eatit.add("женьшень");
        eatit.add("земляника");
        eatit.add("ирис");
        eatit.add("картофель");
        for (String s : eatit) {
            System.out.println(s);
        }
        //напишите тут ваш код

    }
}
