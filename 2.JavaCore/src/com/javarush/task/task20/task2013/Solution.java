package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public Person getMother() {
            return mother;
        }

        public Person getFather() {
            return father;
        }

        public List<Person> getChildren() {
            return children;
        }

        public Person(){

        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person) in.readObject();
            father = (Person) in.readObject();
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
//            System.out.println(in.readLine());
//            System.out.println(in.readLine());
            children = (List<Person>) in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person ivanov = new Person("Ivan", "Ivanov", 99);
        Person ivanova = new Person("Olga", "Ivanova", 88);
        Person junior = new Person("Petr", "Ivanov", 55);
        junior.setFather(ivanov);
        junior.setMother(ivanova);
        junior.setChildren(Arrays.asList(null, null));
        System.out.println(junior.getChildren());
        System.out.println();
        File file = new File("d:\\1.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        junior.writeExternal(objectOutputStream);
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Person newPerson = new Person("df", "sdfsdf", 44);
        newPerson.setMother(ivanova);
        newPerson.setFather(ivanov);
        Person child = new Person();
        newPerson.setChildren(Arrays.asList(child));
//        System.out.println(newPerson.getAge());
//        System.out.println(newPerson.getFirstName());
//        System.out.println(newPerson.getLastName());
//        System.out.println(newPerson.getFather());
//        System.out.println(newPerson.getMother());
//        System.out.println(newPerson.getChildren());
        newPerson.readExternal(objectInputStream);
    }
}
