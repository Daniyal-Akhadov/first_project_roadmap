package org.example.game;

import java.util.HashSet;
import java.util.Set;

public final class User {
    private final int uniqueWordLettersCount;
    private final Set<Character> guessedLetters;

    private int mistakesCount = 0;
    private int guessesCount = 0;

    public User(int uniqueWordLettersCount) {
        this.uniqueWordLettersCount = uniqueWordLettersCount;
        this.guessedLetters = new HashSet<>();
    }

    public Set<Character> getGuessedLetters() {
        return new HashSet<>(guessedLetters);
    }

    public boolean guessedLettersContains(char character) {
        return guessedLetters.contains(character);
    }

    public boolean canPlay(final int availableMistakesCount) {
        return isWinner() == false && canMakeMistakes(availableMistakesCount);
    }

    public boolean isWinner() {
        return uniqueWordLettersCount == guessesCount;
    }

    public void addMistake() {
        mistakesCount++;
    }

    public void addGuesses(char letter) {
        guessedLetters.add(letter);
        guessesCount++;
    }

    public int getMistakesCount() {
        return mistakesCount;
    }

    private boolean canMakeMistakes(final int availableMistakesCount) {
        return mistakesCount < availableMistakesCount;
    }
}
