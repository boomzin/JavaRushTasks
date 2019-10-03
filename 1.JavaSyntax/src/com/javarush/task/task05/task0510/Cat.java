package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    String name;
    String address;
    String color;
    int age;
    int weight;

    public void initialize(String name){
        this.name=name;
        this.age=5;
        this.weight=4;
        this.address=null;
        this.color="black";
    }
    public void initialize(String name, int weight,int age){
        this.name=name;
        this.age=age;
        this.weight=weight;
        this.address=null;
        this.color="black";
    }
    public void initialize(String name, int age){
        this.name=name;
        this.age=age;
        this.weight=4;
        this.address=null;
        this.color="black";
    }
    public void initialize(int weight, String color){
        this.name=null;
        this.age=5;
        this.weight=weight;
        this.address=null;
        this.color=color;
    }
    public void initialize(int weight, String color, String address){
        this.name=null;
        this.age=5;
        this.weight=weight;
        this.address=address;
        this.color=color;
    }

    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
