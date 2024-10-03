package org.example.game;

public final class MistakesTracker {
    private final int AVAILABLE_MISTAKES_COUNT;

    private int currentMistakesCount = 0;

    public MistakesTracker(int availableMistakesCount) {
        AVAILABLE_MISTAKES_COUNT = availableMistakesCount;
    }

    public boolean canMakeMistakes() {
        return currentMistakesCount < AVAILABLE_MISTAKES_COUNT;
    }

    public void addMistake() {
        currentMistakesCount++;
    }

    public int getAvailableMistakesCount() {
        return AVAILABLE_MISTAKES_COUNT;
    }

    public int getCurrentMistakesCount() {
        return currentMistakesCount;
    }
}
