package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    public static final int MAX_V = 125;
    public static final int MAX_TOP = 0;
    public static final int MAX_BOTTON = 480;

    Image imgC = new ImageIcon("res/player.png").getImage();
    Image imgL = new ImageIcon("res/player_left.png").getImage();
    Image imgR = new ImageIcon("res/player_right.png").getImage();

    Image img = imgC;


    int v = 0;
    int dv = 0;
    int s = 0;

    int x = 50;
    int y = 30;
    int dy = 0;

    int layer1 = 0;
    int layer2 = 1200;

    public Rectangle getRect() {
        return new Rectangle(x, y, 178, 87);
    }

    public void move() {
        s = s + v;
        v = v + dv;

        if (v <= 0) {
            v = 0;
        }
        if (v >= MAX_V) {
            v = MAX_V;
        }

        y = y - dy;

        if (y <= MAX_TOP) {
            y = MAX_TOP;
        }
        if (y >= MAX_BOTTON) {
            y = MAX_BOTTON;
        }

        if (layer2 - v <= 0) {
            layer1 = 0;
            layer2 = 1200;
        } else {
            layer1 = layer1 - v;
            layer2 = layer2 - v;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dv = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dv = 3;
        }

        if (key == KeyEvent.VK_UP) {
            img = imgL;
            dy = 10;
        }
        if (key == KeyEvent.VK_DOWN) {
            img = imgR;
            dy = -10;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dv = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dv = 0;
        }

        if (key == KeyEvent.VK_UP) {
            img = imgC;
            dy = 0;
        }
        if (key == KeyEvent.VK_DOWN) {
            img = imgC;
            dy = 0;
        }

    }
}
