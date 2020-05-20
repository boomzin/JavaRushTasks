package com.javarush.task.task20.task2022;

import java.io.*;

/*
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    String filename;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.filename = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(this.filename, true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution("d:\\1.txt");
        solution.writeObject("dfdf.");
        solution.close();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\2.txt"));
        oos.writeObject(solution);

        Solution ns = new Solution("d:\\3.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\2.txt"));
        ns = (Solution) ois.readObject();
        ns.writeObject("2wsx");
        ns.close();

    }
}
