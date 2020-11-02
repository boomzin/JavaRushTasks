package com.javarush.task.task36.task3604;

/* 
Разбираемся в красно-черном дереве
*/
public class Solution {
    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree();
        System.out.println(redBlackTree.isEmpty());
        redBlackTree.insert(15);
        redBlackTree.insert(25);
        redBlackTree.insert(35);
        redBlackTree.insert(45);
        redBlackTree.insert(45);
        System.out.println(redBlackTree.isEmpty());
        redBlackTree.clear();
        System.out.println(redBlackTree.isEmpty());

    }
}
