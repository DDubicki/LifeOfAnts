package com.codecool.ant;

import com.codecool.geometry.Direction;
import com.codecool.geometry.Position;

public class Worker extends Ant {

    public static final char WORKER_SYMBOL = 'W';

    public Worker(Position position) {
        super(position, WORKER_SYMBOL);
    }

    @Override
    public void act() {
        Direction currentDirection = Direction.getRandomDirection();
        position = position.nextPositionInDirection(currentDirection);
    }
}
