package org.example.game;

import org.example.game.gallows.Gallows;
import org.example.input.GameInputHandler;
import org.example.input.UserInputHandler;
import org.example.view.GameView;

import java.util.List;
import java.util.Scanner;

public class GameFactory {
    private final Scanner scanner;
    private final List<String> words;

    public GameFactory(final Scanner scanner, final List<String> words) {
        this.scanner = scanner;
        this.words = words;
    }

    public Game createGame(final int availableMistakesCount) {
        final RandomWordChooser randomWordChooser = new RandomWordChooser(words);
        final MaskedWord maskedWord = new MaskedWord(randomWordChooser.get());

        final Gallows gallows = new Gallows();
        final GameView gameView = new GameView(gallows);
        final UserInputHandler userInputHandler = new GameInputHandler(scanner);
        final MistakesTracker mistakesTracker = new MistakesTracker(availableMistakesCount);

        return new Game(userInputHandler, maskedWord, gameView, mistakesTracker);
    }
}