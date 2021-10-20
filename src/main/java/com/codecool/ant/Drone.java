package com.codecool.ant;

import com.codecool.geometry.Direction;
import com.codecool.geometry.Position;

import java.util.Objects;

public class Drone extends Ant {

    public static final char DRONE_SYMBOL = 'D';
    private Direction currentDirection;

    public Drone(Position position) {
        super(position, DRONE_SYMBOL);
        this.currentDirection = Direction.getRandomDirection();
    }

    @Override
    public void act(int width) {
        /**
         * Drones move one step closer to the queen.
         * If they reach the queen's position, they are kicked off in one of the four directions (chosen randomly),
         * to the edge of the colony (so width / 2 steps away.)
         * Ignore mating for now.
         */
        int queenPosition = width / 2;
        int difX = getDifference(queenPosition, getPosition().x);
        int difY = getDifference(queenPosition, getPosition().y);

        currentDirection = currentDirection.getCloserToQueenDirection(difX, difY);
        position = position.nextPositionInDirection(Objects.requireNonNull(currentDirection));
    }

    private int getDifference(int queenPosition, int dronePosition) {
        int differenceInPosition = 0;
        if (dronePosition < queenPosition) {
            differenceInPosition++;
        } else if (dronePosition > queenPosition) {
            differenceInPosition--;
        }
        return differenceInPosition;
    }
}
