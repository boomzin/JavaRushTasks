package com.javarush.task.task24.task2413;

import java.util.List;

public class Arkanoid {
    private int width;
    private int height;
    private List<Brick> bricks;
    private Stand stand;
    private Ball ball;
    static Arkanoid game;

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public Stand getStand() {
        return stand;
    }

    public Ball getBall() {
        return ball;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static void main(String[] args) {

    }

    public void run() {

    }
    public void move() {

    }
    
}
