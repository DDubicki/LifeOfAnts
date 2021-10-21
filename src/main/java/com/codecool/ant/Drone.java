package com.codecool.ant;

import com.codecool.geometry.Direction;
import com.codecool.geometry.Position;

import java.util.Objects;

public class Drone extends Ant {

    public static final char DRONE_SYMBOL = 'D';
    private Direction currentDirection;
    private boolean isMating;
    private int moodTurns = 0;

    public Drone(Position position) {
        super(position, DRONE_SYMBOL);
        this.currentDirection = Direction.getRandomDirection();
        this.isMating = false;
    }

    @Override
    public void act(int width) {
        int queenPosition = width / 2;
        int absDifferenceToQueenPositionX = Math.abs(queenPosition - getPosition().x);
        int absDifferenceToQueenPositionY = Math.abs(queenPosition - getPosition().y);

        if ((absDifferenceToQueenPositionX == 0 && absDifferenceToQueenPositionY == 1) || (absDifferenceToQueenPositionX == 1 && absDifferenceToQueenPositionY == 0)) {
            standNearToQueen(width);
        } else {
            makeMove(queenPosition, width);
        }
    }

    private void standNearToQueen(int width) {
        if (Queen.isMatingMood()) {
            Queen.setMating();
            this.isMating = true;
            moodTurns++;
        } else if (this.isMating) {
            if (moodTurns < 10) {
                moodTurns++;
            } else {
                this.isMating = false;
                moodTurns = 0;
                kickOfAnt(width);
            }
        } else {
            kickOfAnt(width);
        }
    }

    private void kickOfAnt(int width) {
        int positionX = 0;
        int positionY = 0;
        currentDirection = Direction.getRandomDirection();
        if (currentDirection.differenceX == 0) {
            positionY = currentDirection.differenceY == 1 ? width / 2 : -(width / 2);
        }
        else {
            positionX = currentDirection.differenceX == 1 ? width / 2 : -(width / 2);
        }
        Position newPosition = new Position(positionX, positionY);
        setPosition(newPosition);
    }

    private void makeMove(int queenPosition, int width) {
        int difX = getDifference(queenPosition, getPosition().x);
        int difY = getDifference(queenPosition, getPosition().y);
        do {
            currentDirection = currentDirection.getCloserToQueenDirection(difX, difY);
            position = position.nextPositionInDirection(Objects.requireNonNull(currentDirection));
        } while (position.isOutBoardPosition(width));
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
