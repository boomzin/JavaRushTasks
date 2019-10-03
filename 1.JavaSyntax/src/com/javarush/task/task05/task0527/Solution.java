package com.javarush.task.task05.task0527;

/* 
Том и Джерри
*/

import java.util.Calendar;

public class Solution {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);
        Dog bobDog = new Dog("Bob", 5,true);
        Cat tomCat = new Cat("Tom",6,3);

        //напишите тут ваш код
    }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }
    public static class Dog{
        String name;
        int age;
        boolean sex;
        public Dog( String name, int age, boolean sex){
            this.age=age;
            this.name=name;
            this.sex=sex;
        }
    }
    public static class Cat{
        String name;
        int age;
        int weight;

        public Cat (String name, int age, int weight){
            this.name=name;
            this.age=age;
            this.weight=weight;
        }
    }

    //напишите тут ваш код
}
