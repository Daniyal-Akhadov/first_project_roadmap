package org.example.game;

import org.example.input.UserInputHandler;
import org.example.view.GameView;

public final class Game {
    private final UserInputHandler userInputHandler;
    private final MaskedWord maskedWord;
    private final GameView gameView;
    private final MistakesTracker mistakesTracker;
    private final UsedLettersTracker usedLettersTracker;

    public Game(final UserInputHandler userInputHandler,
                final MaskedWord maskedWord,
                final GameView gameView,
                final MistakesTracker mistakesTracker) {
        this.userInputHandler = userInputHandler;
        this.maskedWord = maskedWord;
        this.gameView = gameView;
        this.mistakesTracker = mistakesTracker;
        usedLettersTracker = new UsedLettersTracker();
    }

    public void start() {
        gameView.startGame();
        boolean isWinner = gameLoop();
        gameView.showEndResultFromContext(isWinner);
    }

    private boolean gameLoop() {
        while (canPlay()) {
            gameView.showCurrentGuessedWordState(maskedWord);
            gameView.showUsedSymbols(usedLettersTracker);
            final char userLetter = userInputHandler.getInput();

            if (maskedWord.wordContains(userLetter)) {
                if (maskedWord.maskContains(userLetter)) {
                    gameView.answerAlreadyThere();
                } else {
                    maskedWord.open(userLetter);
                    gameView.wellDone();
                }
            } else {
                if (usedLettersTracker.has(userLetter) == false) {
                    mistakesTracker.addMistake();
                }
                
                gameView.mistake();
            }

            usedLettersTracker.add(userLetter);
            gameView.showResults(mistakesTracker);
        }

        return isWinner();
    }

    private boolean canPlay() {
        return isWinner() == false && mistakesTracker.canMakeMistakes();
    }

    public boolean isWinner() {
        return maskedWord.isMaskOpen();
    }
}


