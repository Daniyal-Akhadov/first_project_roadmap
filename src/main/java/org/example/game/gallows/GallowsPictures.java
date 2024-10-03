package org.example.game.gallows;

import java.util.Arrays;
import java.util.List;

public final class GallowsPictures {
    private final List<String[]> states;

    private final String[] first = {
            " __________",
            "|    .-----|",
            "|    |     |",
            "|          |",
            "|          |",
            "|          |",
            "|__________|"
    };

    private final String[] second = {
            " __________",
            "|    .-----|",
            "|    |     |",
            "|    O     |",
            "|          |",
            "|          |",
            "|__________|"
    };
    private final String[] third = {
            " __________",
            "|    .-----|",
            "|    |     |",
            "|    O     |",
            "|   /|\\    |",
            "|          |",
            "|__________|"
    };
    private final String[] fourth = {
            " __________",
            "|    .-----|",
            "|    |     |",
            "|    O     |",
            "|   /|\\    |",
            "|   / \\    |",
            "|__________|"
    };
    private final String[] fifth = {
            " __________",
            "|    .-----|",
            "|    |     |",
            "|   \\O/    |",
            "|    |     |",
            "|   / \\    |",
            "|__________|"
    };

    public GallowsPictures() {
        this.states = Arrays.asList(first, second, third, fourth, fifth);
    }

    public String[] get(int pictureState) {
        return states.get(pictureState);
    }
}
