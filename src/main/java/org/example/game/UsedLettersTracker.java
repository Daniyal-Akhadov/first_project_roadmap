package org.example.game;

import java.util.LinkedHashSet;
import java.util.Set;

public final class UsedLettersTracker {
    private final Set<Character> usedLetters;

    public UsedLettersTracker() {
        this.usedLetters = new LinkedHashSet<>();
    }

    public void add(final char letter) {
        usedLetters.add(letter);
    }

    public boolean has(final char letter) {
        return usedLetters.contains(letter);
    }

    public Set<Character> getUsedLetters() {
        return new LinkedHashSet<>(usedLetters);
    }
}
