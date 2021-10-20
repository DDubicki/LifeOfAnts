package com.codecool;

import com.codecool.ant.*;
import com.codecool.geometry.Position;

import java.util.*;

public class Colony {

    private final int width;
    private Map<Position, List<Ant>> board;
    private List<Ant> allAnts;

    public Colony(int width) {
        this.width = width;
        this.board = new HashMap<>();
        this.allAnts = new ArrayList<>();
        createQueen(width);
    }

    private void createQueen(int width) {
        Queen queen = new Queen(new Position(width / 2, width / 2));

        List<Ant> antsAtQueenPosition = new ArrayList<>();
        antsAtQueenPosition.add(queen);

        board.put(queen.getPosition(), antsAtQueenPosition);
        allAnts.add(queen);
    }

    public void generateAnts(int dronesNumber, int workersNumber, int soldiersNumber) {
        generateAnts(dronesNumber, AntType.DRONE);
        generateAnts(workersNumber, AntType.WORKER);
        generateAnts(soldiersNumber, AntType.SOLDIER);
    }

    public void update() {
        for (Ant ant : allAnts) {
            ant.act(width);
        }
    }

    public void display() {
        StringBuilder map = new StringBuilder();
        for (int y = 0; y < width; y++) {
            for (int x = 0; x < width; x++) {
                List<Ant> ants = board.getOrDefault(new Position(x, y), Collections.emptyList());
                map.append(ants.isEmpty() ? "_" : ants.get(0).getSymbol());
                map.append(" ");
            }
            map.append("|\n");
        }
        System.out.println(map);
    }

    private void generateAnts(int ants, AntType type) {
        for (int i = 0; i < ants; i++) {
            Position antPosition = generatePosition();
            Ant ant = createAnt(antPosition, type);

            List<Ant> antsAtThisPosition = board.getOrDefault(antPosition, new ArrayList<>());
            antsAtThisPosition.add(ant);

            board.put(antPosition, antsAtThisPosition);
            allAnts.add(ant);
        }
    }

    private Ant createAnt(Position antPosition, AntType type) {
        switch (type) {
            case DRONE:
                return new Drone(antPosition);
            case WORKER:
                return new Worker(antPosition);
            case SOLDIER:
                return new Soldier(antPosition);
        }
        throw new IllegalArgumentException("There is no ant with type: " + type);
//        throw new IllegalStateException("When state is wrong");
    }

    private Position generatePosition() {
        int x = RandomHelper.nextInt(width);
        int y = RandomHelper.nextInt(width);
        return new Position(x, y);
    }
}
