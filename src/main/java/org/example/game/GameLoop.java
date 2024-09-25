package org.example.game;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public final class GameLoop {

    private final Scanner scanner;
    private final Gallows gallows;
    private final String generatedHiddenWord;
    private final int uniqueWordLettersCount;

    private static final int AVAILABLE_MISTAKES_COUNT = 4;

    public GameLoop(final Scanner scanner, final Gallows gallows, String generatedHiddenWord) {
        this.scanner = scanner;
        this.gallows = gallows;
        this.generatedHiddenWord = generatedHiddenWord;
        uniqueWordLettersCount = getUniqueWordLettersCount(generatedHiddenWord);
    }

    public void start() {
        boolean isWinner = startProcess(generatedHiddenWord);
        printEndResultFromContext(isWinner);
    }

    private boolean startProcess(final String hiddenWord) {
        final User user = new User(uniqueWordLettersCount);

        while (user.canPlay(AVAILABLE_MISTAKES_COUNT)) {
            printCurrentGuessedWordState(hiddenWord, user.getGuessedLetters());
            final char validationUserLetter = askValidationUserLetter();

            if (hiddenWord.contains(String.valueOf(validationUserLetter))) {

                if (user.guessedLettersContains(validationUserLetter)) {
                    System.out.println("\nТакой ответ уже был!");
                } else {
                    user.addGuesses(validationUserLetter);
                    System.out.println("\nТак держать!");
                }
            } else {
                user.addMistake();
                System.out.println("\nОшибка!");
            }

            printResults(user.getMistakesCount());
        }

        return user.isWinner();
    }

    private static void printEndResultFromContext(final boolean isWinner) {
        if (isWinner) {
            System.out.println("\nС победой!\n");
        } else {
            System.out.println("\nВы проиграли!\n");
        }
    }

    private char askValidationUserLetter() {
        char character;

        while (true) {
            System.out.print("Напишите букву в слове: ");
            String input;

            if (scanner.hasNext() && (input = scanner.next()).length() == 1) {
                character = input.charAt(0);
                break;
            } else {
                System.out.println("Неправильный ввод. Пожалуйста, введите один символ.");
            }
        }

        return character;
    }

    private static int getUniqueWordLettersCount(final String hiddenWord) {
        Set<Character> uniqueChars = hiddenWord.chars()
                .mapToObj(c -> (char) c).collect(Collectors.toSet());
        return uniqueChars.size();
    }

    private static void printCurrentGuessedWordState(final String hiddenWord, final Set<Character> guessedCharacters) {
        System.out.print("\nЗагаданное слово: ");

        for (int i = 0; i < hiddenWord.length(); i++) {
            char character = hiddenWord.charAt(i);

            if (guessedCharacters.contains(character)) {
                System.out.print(character);
            } else {
                System.out.print("_");
            }
        }

        System.out.println("\n");
    }

    private void printResults(final int mistakesCount) {
        System.out.println("\nСовершено ошибок: " + mistakesCount + " из " + AVAILABLE_MISTAKES_COUNT + "\n");
        gallows.drawWithRope(mistakesCount);
    }
}



