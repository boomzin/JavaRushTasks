package com.javarush.task.task36.task3602;

import javax.management.AttributeList;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* 
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция
*/
public class Solution {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class[] classes = Collections.class.getDeclaredClasses();
        for (int i = 0; i < classes.length; i++) {
            boolean listImplement = false;
            int classModifiers = classes[i].getModifiers();
            Class superClass = classes[i].getSuperclass();
            Class[] interfaces = superClass.getInterfaces();
            for (int j = 0; j < interfaces.length; j++) {
                if (interfaces[j].getSimpleName().equals("List")) {
                    listImplement = true;
                }
            }
            interfaces = classes[i].getInterfaces();
            for (int j = 0; j < interfaces.length; j++) {
                if (interfaces[j].getSimpleName().equals("List")) {
                    listImplement = true;
                }
            }
            if (listImplement && Modifier.isPrivate(classModifiers) && Modifier.isStatic(classModifiers)) {

                try {
                    Constructor constructor = classes[i].getDeclaredConstructor();
                    constructor.setAccessible(true);
                    Object result = constructor.newInstance();
                    Method getMethod = result.getClass().getDeclaredMethod("get", int.class);
                    getMethod.setAccessible(true);
                    getMethod.invoke(result, 10);
                } catch (NoSuchMethodException e) {
                } catch (InvocationTargetException e) {
                    if (e.getCause().getClass().getSimpleName().equals("IndexOutOfBoundsException")) {
                        return classes[i];
                    }
                }
            }

        }
        return null;
    }
}
