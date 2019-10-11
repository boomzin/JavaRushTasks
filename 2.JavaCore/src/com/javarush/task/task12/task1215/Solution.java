package com.javarush.task.task12.task1215;

/* 
Кошки не должны быть абстрактными!
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public abstract String getName();

        public abstract Pet getChild();
    }

    public static class Cat extends Pet{
        public Pet getChild(){
            Pet pet= new Cat();
            return pet;
        }
        public String getName(){
            return "dfdf";
        }

    }

    public static class Dog extends Pet{
        public Pet getChild(){
            Dog dog=new Dog();
            return dog;
        }
        public String getName(){
            return "dog";
        }

    }

}
