package com.codecool.ant;

import com.codecool.geometry.Position;

public class Queen extends Ant {

    public static final char QUEEN_SYMBOL = 'Q';

    public Queen(Position position) {
        super(position, QUEEN_SYMBOL);
    }

    @Override
    public void act() {

    }

    public void isMatingMood() {
    }
}
