package com.javarush.task.task12.task1220;

import java.util.Arrays;

public class Program{

    public static void main(String[] args) {

        Object[] numbers = new Object[100];
        Arrays.fill(numbers, new Object() {    //создаем анонимный класс
            private int count = 0;
            @Override
            public String toString() {
                return Integer.toString(++count);
            }
        });
        System.out.println(Arrays.toString(numbers));

//
//        Printable printable = createPrintable("Foreign Affairs",false);
//        printable.print();
//
//        read(new Book("Java for impatients", "Cay Horstmann"));
//        read(new Journal("Java Dayly News"));
    }

    static void read(Printable p){

        p.print();
    }

    static Printable createPrintable(String name, boolean option){

        if(option)
            return new Book(name, "Undefined");
        else
            return new Journal(name);
    }
}
interface Printable{

    void print();
}
class Book implements Printable{

    String name;
    String author;

    Book(String name, String author){

        this.name = name;
        this.author = author;
    }

    public void print() {

        System.out.printf("%s (%s) \n", name, author);
        System.out.printf("%s (%s ) %s %s\n", "Hello","brave","new","world");
    }
}
class Journal implements Printable {

    private String name;

    String getName(){
        return name;
    }

    Journal(String name){

        this.name = name;
    }
    public void print() {
        System.out.println(name);
    }
}