package com.javarush.task.task25.task2515;

public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;



    public Canvas(int width, int height) {
        this.height = height;
        this.width = width;
        matrix = new char[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }
}
