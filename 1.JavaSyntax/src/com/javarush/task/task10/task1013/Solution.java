package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

import java.util.Date;

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private int age;
        private boolean sex;
        private Human father;
        private Human mother;
        private Date birthday;

        public Human(){

        }
        public Human(String name, int age){
            this.name=name;
            this.age=age;
        }
        public Human(String name, boolean sex){
            this.name=name;
            this.sex=sex;
        }
        public Human(String name, int age, boolean sex){
            this.name=name;
            this.age=age;
            this.sex=sex;
        }
        public Human(String name,Date birthday){
            this.name=name;
            this.birthday=birthday;
        }
        public Human(String name, int age, Date birthday){
            this.name=name;
            this.age=age;
            this.birthday=birthday;
        }
        public Human(String name, int age, boolean sex, Date birthday){
            this.name=name;
            this.age=age;
            this.sex=sex;
            this.birthday=birthday;
        }
        public Human(String name,Human mother){
            this.name=name;
            this.mother=mother;
        }
        public Human(String name,Human mother,Human father){
            this.name=name;
            this.mother=mother;
            this.father=father;
        }
        public Human(String name, int age, boolean sex,Date birthday, Human mother, Human father){
            this.name=name;
            this.age=age;
            this.sex=sex;
            this.birthday=birthday;
            this.mother=mother;
            this.father=father;
        }
        // Напишите тут ваши переменные и конструкторы
    }
}
