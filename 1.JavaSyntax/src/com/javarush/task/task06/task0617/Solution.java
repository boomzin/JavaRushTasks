package com.javarush.task.task06.task0617;

/* 
Блокнот для новых идей
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution.Idea idea =solution.new Idea();

        solution.printIdea(idea);
    }

    public void printIdea(Idea idea){
        System.out.println(idea.getDescription());
    }


    public class Idea{
        public  String getDescription(){

            return "OMG";
        }
    }
}
