package com.javarush.task.task35.task3507;

import java.io.*;
//import java.lang.reflect.Constructor;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) throws InstantiationException, ClassNotFoundException, IllegalAccessException {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Set<Animal> result = new HashSet<>();
        File classDir = new File(pathToAnimals);
        File[] classList = classDir.listFiles();
        MyLoader myClassLoader = new MyLoader();
        for (int i = 0; i < classList.length; i++) {

            Class loadedClass = myClassLoader.findClass(classList[i].getAbsolutePath());

            try {
                if (Animal.class.isAssignableFrom(loadedClass)) {
                    Object temporaryObject = loadedClass.newInstance();
                    result.add((Animal) temporaryObject);
                }
            } catch (InstantiationException e) {
//                e.printStackTrace();
            } catch (IllegalAccessException e) {
//                e.printStackTrace();
            }
//            try {
//                Class loadedClass = myClassLoader.findClass(classList[i].getAbsolutePath());
//
//                Object temporaryObject = loadedClass.newInstance();
//                if (temporaryObject instanceof Animal) {
//                    result.add((Animal) temporaryObject);
//                }
//            } catch (IllegalAccessException e) {
////                e.printStackTrace();
//            }
        }


        return result;
    }
}
