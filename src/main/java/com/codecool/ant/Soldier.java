package com.codecool.ant;

import com.codecool.geometry.Direction;
import com.codecool.geometry.Position;

public class Soldier extends Ant {

    public static final char SOLDIER_SYMBOL = 'S';
    private Direction currentDirection;

    public Soldier(Position position) {
        super(position, SOLDIER_SYMBOL);
        this.currentDirection = Direction.getRandomDirection();
    }

    @Override
    public void act() {
        currentDirection = currentDirection.turnLeft();
    }
}
