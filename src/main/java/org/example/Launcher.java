package org.example;

import org.example.game.Gallows;
import org.example.game.Game;
import org.example.game.GameLoop;
import org.example.game.HiddenWord;
import org.example.parser.Dictionary;
import org.example.utils.ImmutableArray;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class Launcher {

    private final Scanner scanner;

    public Launcher(final Scanner scanner) {
        this.scanner = scanner;
    }

    public void askUser() {
        loop:
        while (true) {
            try {
                printChoices();
                final int answer = getUserAnswer();

                switch (answer) {
                    case Options.START -> {
                        Game game = createGame();
                        game.start();
                    }
                    case Options.EXIT -> {
                        break loop;
                    }
                    default -> printIncorrectAnswer();
                }
            } catch (NumberFormatException | InputMismatchException exception) {
                printIncorrectAnswer();
                scanner.next();
            } catch (FileNotFoundException exception) {
                System.out.println("\nФайл со словарём не был найден!\n");
                break;
            }
        }
    }

    private Game createGame() throws FileNotFoundException {
        final ImmutableArray<String> words = getWordsFromDictionary();
        final HiddenWord hiddenWord = new HiddenWord(words);
        final String generatedHiddenWord = hiddenWord.generate();
        final Gallows gallows = new Gallows();

        return new Game(new GameLoop(scanner, gallows, generatedHiddenWord));
    }

    private static ImmutableArray<String> getWordsFromDictionary() throws FileNotFoundException {
        final Dictionary dictionary = new Dictionary();
        return dictionary.getWords();
    }

    private int getUserAnswer() throws NumberFormatException {
        System.out.print("\nВаш ответ: ");
        return scanner.nextInt();
    }

    private static void printIncorrectAnswer() {
        System.out.println("\nОтвет некорректный!\n");
    }

    private static void printChoices() {
        System.out.println("1. начать игру");
        System.out.println("2. выйти");
    }

    private static class Options {
        private static final int START = 1;
        private static final int EXIT = 2;
    }
}
