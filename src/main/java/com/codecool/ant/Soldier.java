package com.codecool.ant;

import com.codecool.geometry.Position;

public class Soldier extends Ant {

    public static final char SOLDIER_SYMBOL = 'S';

    public Soldier(Position position) {
        super(position, SOLDIER_SYMBOL);
    }

    @Override
    public void act() {

    }
}
