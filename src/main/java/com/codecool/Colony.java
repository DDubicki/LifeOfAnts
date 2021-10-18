package com.codecool;

import com.codecool.ant.Ant;
import com.codecool.ant.Drone;
import com.codecool.ant.Queen;
import com.codecool.geometry.Position;

import java.util.*;

public class Colony {

    private final Random random;

    private final int width;
    private Map<Position, List<Ant>> board;

    public Colony(int width) {
        this.width = width;
        this.board = new HashMap<>();
        this.random = new Random();
        createQueen(width);
    }

    private void createQueen(int width) {
        Queen queen = new Queen(new Position(width /2, width /2));

        List<Ant> antsAtQueenPosition = new ArrayList<>();
        antsAtQueenPosition.add(queen);
        board.put(queen.getPosition(), antsAtQueenPosition);
    }

    public void generateAnts(int drones, int workers, int soldiers) {
        generateDrones(drones);
    }

    public void update() {
    }

    public void display() {
    }

    private void generateDrones(int drones) {
        for (int i = 0; i < drones; i++) {
            Position dronePosition = generatePosition();
            Drone drone = new Drone(dronePosition);

            List<Ant> antsAtThisPosition = board.getOrDefault(dronePosition, new ArrayList<>());
            antsAtThisPosition.add(drone);
            board.put(dronePosition, antsAtThisPosition);
        }
    }

    private Position generatePosition() {
        int x = random.nextInt(width);
        int y = random.nextInt(width);
        return new Position(x, y);
    }
}
