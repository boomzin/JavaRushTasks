package com.javarush.task.task34.task3410.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.Direction;

public class Field extends JPanel {
    private EventListener eventListener;
    View view;

    public Field(View view) {
        this.view = view;
        KeyHandler keyHandler = new KeyHandler();
        addKeyListener(keyHandler);
        setFocusable(true);
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 500);
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        view.getGameObjects().getAll().forEach(e -> e.draw(g));

    }

    public class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_LEFT) {
                eventListener.move(Direction.LEFT);
            }
            if (keyCode == KeyEvent.VK_RIGHT) {
                eventListener.move(Direction.RIGHT);
            }
            if (keyCode == KeyEvent.VK_UP) {
                eventListener.move(Direction.UP);
            }
            if (keyCode == KeyEvent.VK_DOWN) {
                eventListener.move(Direction.DOWN);
            }
            if (keyCode == KeyEvent.VK_R) {
                eventListener.restart();
            }
        }
    }
}
