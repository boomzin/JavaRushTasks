package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(reader.readLine());
        int m= Integer.parseInt(reader.readLine());
        ArrayList<String> arrayList= new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            arrayList.add(reader.readLine());
        }
        int tmp=0;
        while (tmp<m){
            arrayList.add(arrayList.get(0));
            arrayList.remove(0);
            tmp++;
        }
//        Iterator<String> stringIterator=arrayList.iterator();
//        int tmp=1;
//        while (tmp<m){
//            arrayList.add(stringIterator.next());
//            stringIterator.remove();
//            tmp++;
//        }
        for (String s : arrayList) {
            System.out.println(s);
        }

        //напишите тут ваш код
    }
}
