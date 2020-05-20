package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/
public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();
    public void print() {
        System.out.println(node);
        edges.forEach(a -> System.out.print(a + " "));
        if (edges.size() != 0) {
            edges.forEach(a -> a.print());
        }
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution vertex1 = new Solution();
        vertex1.node = 1;
        Solution vertex11 = new Solution();
        vertex11.node = 11;
        Solution vertex12 = new Solution();
        vertex12.node = 12;
        Solution vertex21 = new Solution();
        vertex21.node = 21;
        Solution vertex3 = new Solution();
        vertex3.node = 3;
        vertex1.edges.add(vertex11);
        vertex1.edges.add(vertex12);
        vertex1.edges.add(vertex21);
        vertex21.edges.add(vertex3);

        vertex1.print();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\1.txt"));
        oos.writeObject(vertex1);
        oos.flush();
        oos.close();

        Solution restoreVertex;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\1.txt"));
        restoreVertex = (Solution) ois.readObject();
        ois.close();
        restoreVertex.print();
    }
}
