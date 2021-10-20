package com.codecool.ant;

import com.codecool.geometry.Position;

public abstract class Ant {

    private final char symbol;
    protected Position position;

    public Ant(Position position, char symbol) {
        this.position = position;
        this.symbol = symbol;
    }

    public abstract void act(int width);

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public char getSymbol() {
        return symbol;
    }
}
