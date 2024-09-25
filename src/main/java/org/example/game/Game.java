package org.example.game;

public final class Game {
    private final GameLoop gameLoop;

    public Game(GameLoop gameLoop) {
        this.gameLoop = gameLoop;
    }

    public void start() {
        System.out.println("\nНачалась игра\n");
        gameLoop.start();
    }
}
