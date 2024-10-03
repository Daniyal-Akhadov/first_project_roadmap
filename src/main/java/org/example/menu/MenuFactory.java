package org.example.menu;

import org.example.game.GameFactory;
import org.example.input.MenuInputHandler;
import org.example.input.UserInputHandler;

import java.util.List;
import java.util.Scanner;

public final class MenuFactory {
    private final Scanner scanner;
    private final List<String> words;
    private final int availableMistakesCount;

    public MenuFactory(final Scanner scanner, final List<String> words, final int availableMistakesCount) {
        this.scanner = scanner;
        this.words = words;
        this.availableMistakesCount = availableMistakesCount;
    }

    public Menu createMenu() {
        final UserInputHandler userInputHandler = new MenuInputHandler(scanner);
        final GameFactory gameFactory = new GameFactory(scanner, words);

        return new Menu(userInputHandler, gameFactory, availableMistakesCount);
    }
}
