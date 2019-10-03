package com.javarush.task;

import java.util.Objects;

public class Cat {
    public int age;
    public static int x;

    public int getAge() {
        return age;
    }

    public Cat(int age) {
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public static void main(String[] args) {

        x = 7;
        incrementNumber(x);
        System.out.println(x);

        Cat cat = new Cat(7);
        catLevelUp(cat);
        System.out.println(cat.getAge());
        int i = 6;
        System.out.println(7 == (i++));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    public static void catLevelUp(Cat cat) {

        cat.setAge(cat.getAge()+1);
    }

    public static void incrementNumber(int  x) {
        Cat.x++;
    }
}
