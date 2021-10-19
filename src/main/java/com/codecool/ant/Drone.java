package com.codecool.ant;

import com.codecool.geometry.Position;

public class Drone extends Ant {

    public static final char DRONE_SYMBOL = 'D';

    public Drone(Position position) {
        super(position, DRONE_SYMBOL);
    }

    @Override
    public void act() {

    }
}
