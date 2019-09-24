package com.company;

import javax.swing.*;
import java.awt.*;

public class Enemy {
    int x;
    int y;
    int v;
    Image image = new ImageIcon("res/enemy.png").getImage();
    Road road;

    public Rectangle getRect() {
        return new Rectangle(x, y, 217, 78);
    }

    public Enemy(int x, int y, int v, Road road) {
        this.x = x;
        this.y = y;
        this.v = v;
        this.road = road;
    }

    public void move() {
        x = x - road.p.v + v;
    }
}
