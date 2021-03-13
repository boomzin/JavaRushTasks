package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/

import java.lang.reflect.Field;
import java.util.Objects;

public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }


        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B implements Cloneable{
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            int i = 0;
            int j = 0;
            String name = null;
            try {
                Field fieldI = A.class.getDeclaredField("i");
                Field fieldJ = A.class.getDeclaredField("j");
                Field fieldName = B.class.getDeclaredField("name");
                fieldI.setAccessible(true);
                fieldJ.setAccessible(true);
                fieldName.setAccessible(true);
                i = (int) fieldI.get(this);
                j = (int) fieldJ.get(this);
                name = (String) fieldName.get(this);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return new C(i, j, name);
        }
    }

    public static void main(String[] args) {
        C c = new C(4, 5, "sf");
        try {
            C clone = (C) c.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
