package com.codecool;

import com.codecool.ant.Ant;
import com.codecool.ant.Queen;
import com.codecool.geometry.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Colony {

    private final int width;
    private Map<Position, List<Ant>> board;

    public Colony(int width) {
        this.width = width;
        this.board = new HashMap<>();
        createQueen(width);
    }

    private void createQueen(int width) {
        Queen queen = new Queen(new Position(width /2, width /2));

        List<Ant> antsAtQueenPosition = new ArrayList<>();
        antsAtQueenPosition.add(queen);
        board.put(queen.getPosition(), antsAtQueenPosition);
    }

    public void generateAnts(int drones, int workers, int soldiers) {
    }

    public void update() {
    }

    public void display() {
    }
}
