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
        int queenPosition = width / 2;
        int difX = getDifference(queenPosition, getPosition().x);
        int difY = getDifference(queenPosition, getPosition().y);
        chooseCurrentMove(difX, difY, width);
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

    private void chooseCurrentMove(int difX, int difY, int width) {

        if (difX == 0 && difY == 0) {
            kickOfAnt(width);
        } else {
            do {
                makeMoveCloserToQueen(difX, difY);
            } while (position.isOutBoardPosition(width));
        }
    }

    private void kickOfAnt(int width) {
        int positionX = 0;
        int positionY = 0;
        currentDirection = Direction.getRandomDirection();
        if (currentDirection.differenceX == 0)
            positionY = currentDirection.differenceY == 1 ? width / 2 : -(width / 2);
        else
            positionX = currentDirection.differenceX == 1 ? width / 2 : -(width / 2);
        Position newPosition = new Position(positionX, positionY);
        setPosition(newPosition);
    }

    private void makeMoveCloserToQueen(int difX, int difY) {
        currentDirection = currentDirection.getCloserToQueenDirection(difX, difY);
        position = position.nextPositionInDirection(Objects.requireNonNull(currentDirection));
    }
}
