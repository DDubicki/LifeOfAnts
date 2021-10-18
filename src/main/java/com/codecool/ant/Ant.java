package com.codecool.ant;

import com.codecool.geometry.Position;

public abstract class Ant {

    private Position position;

    public Ant(Position position) {
        this.position = position;
    }

    public abstract void move();

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
