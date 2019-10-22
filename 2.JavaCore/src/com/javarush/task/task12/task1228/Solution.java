package com.javarush.task.task12.task1228;

/* 
Интерфейсы к классу Human
*/

public class Solution {
    public static void main(String[] args) {
        Human human = new Human();
        System.out.println(human);
    }


    public interface Worker {
        public void workLazy();
    }

    public interface Businessman {
        public void workHard();
    }

    public interface Secretary {
        public void workLazy();
    }

    public interface Miner {
        public void workVeryHard();
    }

    public static class Human implements Worker, Secretary, Businessman{

        public void workHard() {
        }

        public void workLazy() {
        }
    }
}
