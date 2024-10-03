package org.example.view;

import org.example.game.gallows.Gallows;
import org.example.game.MaskedWord;
import org.example.game.MistakesTracker;
import org.example.game.UsedLettersTracker;

import java.util.Set;

public final class GameView {
    private final Gallows gallows;

    public GameView(Gallows gallows) {
        this.gallows = gallows;
    }

    public void mistake() {
        System.out.println("\nОшибка!");
    }

    public void wellDone() {
        System.out.println("\nТак держать!");
    }

    public void answerAlreadyThere() {
        System.out.println("\nТакой ответ уже был!");
    }

    public void showResults(final MistakesTracker mistakesTracker) {
        int currentMistakesCount = mistakesTracker.getCurrentMistakesCount();

        showMistakesCount(mistakesTracker, currentMistakesCount);
        gallows.draw(currentMistakesCount);
    }

    private static void showMistakesCount(MistakesTracker mistakesTracker, int currentMistakesCount) {
        System.out.println("\nСовершено ошибок: " + currentMistakesCount +
                " из " + mistakesTracker.getAvailableMistakesCount() + "\n");
    }

    public void showCurrentGuessedWordState(final MaskedWord maskedWord) {
        System.out.print("\nЗагаданное слово: ");

        String hiddenWord = maskedWord.getWord();

        for (int i = 0; i < hiddenWord.length(); i++) {
            char character = hiddenWord.charAt(i);

            if (maskedWord.maskContains(character)) {
                System.out.print(character);
            } else {
                System.out.print("_");
            }
        }

        System.out.println("\n");
    }

    public void showEndResultFromContext(final boolean isWinner) {
        if (isWinner) {
            System.out.println("\nС победой!\n");
        } else {
            System.out.println("\nВы проиграли!\n");
        }
    }

    public void startGame() {
        System.out.println("\nНачалась игра\n");
        gallows.draw(0);
    }

    public void showUsedSymbols(UsedLettersTracker usedLettersTracker) {
        Set<Character> usedSymbols = usedLettersTracker.getUsedLetters();

        System.out.print("Использованные символы: ");

        for (Character temp : usedSymbols) {
            System.out.print(temp + ", ");
        }

        System.out.println("\n");
    }
}
