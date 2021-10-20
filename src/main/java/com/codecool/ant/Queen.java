package com.codecool.ant;

import com.codecool.RandomHelper;
import com.codecool.geometry.Position;

public class Queen extends Ant {

    public static final char QUEEN_SYMBOL = 'Q';
    public static final int GOOD_MOOD_LOWER_BOUND = 50;
    public static final int GOOD_MOOD_UPPER_BOUND = 100;
    private int goodMoodCountdown;

    public Queen(Position position) {
        super(position, QUEEN_SYMBOL);
        goodMoodCountdown = RandomHelper.nextInt(GOOD_MOOD_LOWER_BOUND, GOOD_MOOD_UPPER_BOUND);
    }

    @Override
    public void act(int width) {
        if (goodMoodCountdown > 0)
            goodMoodCountdown--;
    }

    public boolean isMatingMood() {
        return goodMoodCountdown == 0;
    }
}
