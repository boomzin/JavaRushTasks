package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.nio.file.Paths;
import java.util.Set;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get(String.valueOf(getClass().getResource("../res/levels.txt")).substring(6)));


    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }
    public void startNextLevel() {
        restartLevel(++currentLevel);
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        Set<Wall> walls = gameObjects.getWalls();
        for (Wall wall : walls) {
            if (gameObject.isCollision(wall, direction)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBoxCollisionAndMoveIfAvailable(Direction direction) {
        Set<Box> boxes = gameObjects.getBoxes();
        Player player = gameObjects.getPlayer();
        int nextX = player.x;
        int nextXPlus1 = player.x;
        int nextY = player.y;
        int nextYPlus1 = player.y;
        switch (direction) {
            case RIGHT:
                nextX += FIELD_CELL_SIZE;
                nextXPlus1 += 2 * FIELD_CELL_SIZE;
                break;
            case LEFT:
                nextX -= FIELD_CELL_SIZE;
                nextXPlus1 -= 2 * FIELD_CELL_SIZE;
                break;
            case DOWN:
                nextY += FIELD_CELL_SIZE;
                nextYPlus1 += 2 * FIELD_CELL_SIZE;
                break;
            case UP:
                nextY -= FIELD_CELL_SIZE;
                nextYPlus1 -= 2 * FIELD_CELL_SIZE;
        }
        Box nextBox = null;
        for (Box box : boxes) {
            if (box.x == nextX && box.y == nextY) {
                nextBox = box;
            }
        }
        if (nextBox != null) {
            if (checkWallCollision(nextBox, direction)) {
                return true;
            }
            for (Box box : boxes) {
                if (!nextBox.equals(box) && nextBox.isCollision(box, direction)) {
                    return true;
                }
            }
            nextBox.move(nextXPlus1 - nextX, nextYPlus1 - nextY);
        }

        return false;
    }

    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();
        if (checkWallCollision(player, direction)) {
            return;
        }
        if (checkBoxCollisionAndMoveIfAvailable(direction)) {
            return;
        }
        switch (direction) {
            case RIGHT:
                player.x += FIELD_CELL_SIZE;
                break;
            case LEFT:
                player.x -= FIELD_CELL_SIZE;
                break;
            case DOWN:
                player.y += FIELD_CELL_SIZE;
                break;
            case UP:
                player.y -= FIELD_CELL_SIZE;
        }
        checkCompletion();
    }

    public void checkCompletion() {
        Set<Box> boxes = gameObjects.getBoxes();
        Set<Home> homes = gameObjects.getHomes();
        for (Box box : boxes) {
            boolean boxInHome = false;
            for (Home home : homes) {
                if (box.x == home.x && box.y == home.y) {
                    boxInHome = true;
                    break;
                }
            }
            if (!boxInHome) {
                return;
            }
        }
        eventListener.levelCompleted(currentLevel);
    }
}
