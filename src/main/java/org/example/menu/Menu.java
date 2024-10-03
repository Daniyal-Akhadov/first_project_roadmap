package org.example.menu;

import org.example.game.Game;
import org.example.game.GameFactory;
import org.example.input.UserInputHandler;

public final class Menu {
    private final UserInputHandler userInputHandler;
    private final GameFactory gameFactory;
    private final int availableMistakesCount;

    public Menu(final UserInputHandler userInputHandler, final GameFactory gameFactory, final int availableMistakesCount) {
        this.userInputHandler = userInputHandler;
        this.gameFactory = gameFactory;
        this.availableMistakesCount = availableMistakesCount;
    }

    public void handleUserSelection() {
        loop:
        while (true) {
            final int answer = getUserInput();

            switch (answer) {
                case Options.START -> {
                    Game game = gameFactory.createGame(availableMistakesCount);
                    game.start();
                }
                case Options.EXIT -> {
                    break loop;
                }
            }
        }
    }

    private int getUserInput() {
        return Character.getNumericValue(userInputHandler.getInput());
    }
}


