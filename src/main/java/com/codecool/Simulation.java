package com.codecool;

import java.util.Scanner;

public class Simulation {

    private final Colony colony;

    public Simulation() {
        colony = new Colony(20);
        colony.generateAnts(5, 10, 15);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        do {
            colony.update();
            colony.display();
        } while (!scanner.nextLine().equalsIgnoreCase("q"));
    }
}
