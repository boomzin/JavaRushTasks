package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(12.12,"1");
        labels.put(122.1,"12");
        labels.put(123.1,"13");
        labels.put(124.1,"14");
        labels.put(125.0,"15");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
