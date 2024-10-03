package org.example.game;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class MaskedWord {
    private final String word;
    private final Set<Character> mask;
    private final int uniqueWordLettersCount;

    public MaskedWord(final String word) {
        this.word = word;
        mask = new HashSet<>();
        uniqueWordLettersCount = getUniqueWordLettersCount(word);
    }

    public String getWord() {
        return word;
    }
    
    public void open(final char letter) {
        mask.add(letter);
    }

    public boolean wordContains(final char letter) {
        return word.contains(String.valueOf(letter));
    }

    public boolean maskContains(char letter) {
        return mask.contains(letter);
    }

    public boolean isMaskOpen() {
        return mask.size() == getUniqueWordLettersCount();
    }

    private static int getUniqueWordLettersCount(final String hiddenWord) {
        Set<Character> uniqueChars = hiddenWord.chars()
                .mapToObj(c -> (char) c).collect(Collectors.toSet());
        return uniqueChars.size();
    }

    private int getUniqueWordLettersCount() {
        return uniqueWordLettersCount;
    }
}
