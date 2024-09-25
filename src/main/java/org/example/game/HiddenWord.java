package org.example.game;

import org.example.utils.ImmutableArray;

import java.util.Random;

public final class HiddenWord {
    private final ImmutableArray<String> words;

    public HiddenWord(final ImmutableArray<String> words) {
        this.words = words;
    }

    public String generate() {
        final int randomIndex = new Random().nextInt(words.length());
        return words.get(randomIndex);
    }
}
