package com.javarush.task.task21.task2108;

/* 
Клонирование растений
*/


import java.lang.reflect.Field;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = (Tree) tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);

//        tree.setName("1111");
//        System.out.println(tree.getName());
//        System.out.println(clone.getName());

        String[] treeBranches = tree.getBranches();
        String[] cloneBranches = clone.getBranches();
        for (int i = 0; i < treeBranches.length; i++) {
            System.out.println(treeBranches[i] == cloneBranches[i]);
        }

//        System.out.println(Arrays.toString(treeBranches));
//        treeBranches[0] = "ss";
//        System.out.println(Arrays.toString(treeBranches));
//
//        treeBranches = tree.getBranches();
//        System.out.println(Arrays.toString(treeBranches));
//        treeBranches = clone.getBranches();
//        System.out.println(Arrays.toString(treeBranches));


        System.out.println(tree.branches);
        System.out.println(clone.branches);


    }

    public static class Plant {
        private String name;

        public Plant(String name) {
            this.name = name;
        }


        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable{
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            String[] strings = new String[this.branches.length];
            for (int i = 0; i < branches.length; i++) {
                strings[i] = new String(branches[i]);
            }
            String name = null;
            try {
                Field field = Plant.class.getDeclaredField("name");
                field.setAccessible(true);
                name = (String) field.get(this);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return new Tree(new String(name), strings);
        }
    }
}
