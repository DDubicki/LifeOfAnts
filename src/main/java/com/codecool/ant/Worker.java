package com.codecool.ant;

import com.codecool.geometry.Direction;
import com.codecool.geometry.Position;

public class Worker extends Ant {

    public static final char WORKER_SYMBOL = 'W';
    private Direction currentDirection;

    public Worker(Position position) {
        super(position, WORKER_SYMBOL);
        this.currentDirection = Direction.getRandomDirection();
    }

    @Override
    public void act(int width) {
        if ((getPosition().x > width) || (getPosition().x < 0) || (getPosition().y > width) || (getPosition().y < 0)) {
            position.nextPositionInDirection(currentDirection.turnBack());
        } else {
            currentDirection = Direction.getRandomDirection();
            position = position.nextPositionInDirection(currentDirection);
        }
    }
}
