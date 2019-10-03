package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> mlist = new ArrayList<>();
        ArrayList<Integer> trilist = new ArrayList<>();
        ArrayList<Integer> twolist = new ArrayList<>();
        ArrayList<Integer> otherlist = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            mlist.add(Integer.parseInt(bufferedReader.readLine()));
        }
        for (Integer x: mlist) {
            if (x%3==0){
                if (x%2==0){
                    trilist.add(x);
                    twolist.add(x);
                }
                else {
                    trilist.add(x);
                }
            }
            else if (x%2==0){
                twolist.add(x);
            }
            else {
                otherlist.add(x);
            }
        }
        printList(trilist);
        printList(twolist);
        printList(otherlist);
        //напишите тут ваш код
    }

    public static void printList(ArrayList<Integer> list) {
        for (Integer x: list) {
            System.out.println(x);
        }
        //напишите тут ваш код
    }
}
