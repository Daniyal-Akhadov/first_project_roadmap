package org.example.game;

import java.util.List;
import java.util.Random;

public final class RandomWordChooser {
    private final List<String> words;

    public RandomWordChooser(final List<String> words) {
        this.words = words;
    }

    public String get() {
        final int randomIndex = new Random().nextInt(words.size());
        return words.get(randomIndex);
    }
}
