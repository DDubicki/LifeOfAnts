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
    public void act(int width) {
        if ((getPosition().x > width) || (getPosition().x < 0) || (getPosition().y > width) || (getPosition().y < 0)) {
            position.nextPositionInDirection(currentDirection.turnBack());
        } else {
            currentDirection = currentDirection.turnLeft();
            position = position.nextPositionInDirection(currentDirection);
        }
    }
}
