package com.codecool.geometry;

import com.codecool.RandomHelper;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public static Direction getRandomDirection() {
        Direction[] values = values();
        int i = RandomHelper.nextInt(values.length);
        return values[i];
    }

    public Direction turnLeft() {
        Direction[] values = values();
//        int i = this.ordinal() + 3 % values.length;
        int i = (this.ordinal() - 1 + values.length) % values.length;
        return values[i];
    }
}
