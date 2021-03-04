package com.javarush.task.task34.task3410.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;

        int loopLevel;
        if (level > 60) {
            loopLevel = level % 60;
        } else {
            loopLevel = level;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(levels.toFile()))) {
            int readLevel = 0;
            int x;
            int y = Model.FIELD_CELL_SIZE / 2;
            boolean isLevelMap = false;

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Maze:")) {
                    readLevel = Integer.valueOf(line.split(" ")[1]);
                    continue;
                }
                if (readLevel == loopLevel) {
                    if (line.length() == 0) {
                        boolean isEnd = isLevelMap;

                        isLevelMap = !isLevelMap;

                        if (isEnd && !isLevelMap) {
                            break;
                        } else {
                            continue;
                        }
                    }
                    if (isLevelMap) {
                        x = Model.FIELD_CELL_SIZE / 2;

                        char[] chars = line.toCharArray();
                        for (char c : chars) {
                            switch (c) {
                                case 'X':
                                    walls.add(new Wall(x, y));
                                    break;
                                case '*':
                                    boxes.add(new Box(x, y));
                                    break;
                                case '.':
                                    homes.add(new Home(x, y));
                                    break;
                                case '&':
                                    boxes.add(new Box(x, y));
                                    homes.add(new Home(x, y));
                                    break;
                                case '@':
                                    player = new Player(x, y);
                            }
                            x += Model.FIELD_CELL_SIZE;
                        }
                        y += Model.FIELD_CELL_SIZE;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new GameObjects(walls, boxes, homes, player);
    }


//        level = level % 60;
//        if (level == 0) level = 1;
//        Set<Wall> walls = new HashSet<>();
//        Set<Box> boxes = new HashSet<>();
//        Set<Home> homes = new HashSet<>();
//        Player player = null;
//        List<String> strings = null;
//        try {
//            strings = Files.readAllLines(Paths.get(String.valueOf(getClass().getResource("../res/levels.txt")).substring(6)));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        List<char[]> chars = new ArrayList<>();
//        for (int i = 0; i < strings.size(); i++) {
//            if (("Maze: " + level).equals(strings.get(i))) {
//                int y = Integer.parseInt(strings.get(i + 3).substring(8));
//                for (int j = 0; j < y; j++) {
//                    chars.add(strings.get(i + 7 + j).toCharArray());
//                }
//            }
//        }
//        for (int y = 0; y < chars.size(); y++) {
//            for (int x = 0; x < chars.get(y).length; x++) {
//                int objectX = Model.FIELD_CELL_SIZE / 2 + Model.FIELD_CELL_SIZE * x;
//                int objectY = Model.FIELD_CELL_SIZE /2 + Model.FIELD_CELL_SIZE * y;
//                if (chars.get(y)[x] == 'X') {
//                    walls.add(new Wall(objectX, objectY));
//                }
//                if (chars.get(y)[x] == '*') {
//                    boxes.add(new Box(objectX, objectY));
//                }
//                if (chars.get(y)[x] == '.') {
//                    homes.add(new Home(objectX, objectY));
//                }
//                if (chars.get(y)[x] == '@') {
//                    player = new Player(objectX, objectY);
//                }
//                if (chars.get(y)[x] == '&') {
//                    boxes.add(new Box(objectX, objectY));
//                    homes.add(new Home(objectX, objectY));
//                }
//
//            }
//        }
//
//        return new GameObjects(walls, boxes, homes, player);
//    }
}
