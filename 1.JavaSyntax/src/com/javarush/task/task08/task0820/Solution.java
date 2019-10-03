package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        Set<Cat> result = new HashSet<Cat>();
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());

        //напишите тут ваш код

        return result;
    }

    public static Set<Dog> createDogs() {
        Set<Dog> dogs=new HashSet<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        dogs.add(new Dog());
        //напишите тут ваш код
        return dogs;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        Set pets=new HashSet();
        pets.addAll(cats);
        pets.addAll(dogs);
        //напишите тут ваш код
        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
//        Iterator catiterator=cats.iterator();
//        Object cat =catiterator.next();
        pets.removeIf(x->cats.contains(x));
//        Iterator iterator=pets.iterator();
//        while (iterator.hasNext()){
//            Object pet= iterator.next();
//            if (cats.contains(pet)){
//                iterator.remove();
//            }
//        }

        //напишите тут ваш код
    }

    public static void printPets(Set<Object> pets) {
        Iterator iterator=pets.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //напишите тут ваш код
    }

    public static class Cat{

    }

    public static class Dog{

    }

    //напишите тут ваш код
}
