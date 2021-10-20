package com.codecool.ant;

import com.codecool.geometry.Direction;
import com.codecool.geometry.Position;

public class Worker extends Ant {

    public static final char WORKER_SYMBOL = 'W';
    private final Direction currentDirection;

    public Worker(Position position) {
        super(position, WORKER_SYMBOL);
        this.currentDirection = Direction.getRandomDirection();
    }

    @Override
    public void act(int width) {
        position = position.nextPositionInDirection(currentDirection);
    }
}
