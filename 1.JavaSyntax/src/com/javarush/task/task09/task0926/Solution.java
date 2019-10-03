package com.javarush.task.task09.task0926;

import java.util.ArrayList;
import java.util.Random;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> list1=new ArrayList<>();
        list1.add(new int[5]);
        list1.add(new int[2]);
        list1.add(new int[4]);
        list1.add(new int[7]);
        list1.add(new int[0]);
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list1.get(i).length; j++) {
                list1.get(i)[j]=i*10+j;
            }
        }
        return list1;
        //напишите тут ваш код
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
