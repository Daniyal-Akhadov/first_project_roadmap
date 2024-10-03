package org.example;

import org.example.menu.Menu;
import org.example.menu.MenuFactory;

import java.util.List;
import java.util.Scanner;

public final class EntryPoint {
    public static void main(String[] args) {
        final Dictionary dictionary = getDictionary();
        List<String> words = dictionary.getWords();

        if (words.isEmpty()) {
            return;
        }

        final int availableMistakesCount = 4;
        final Scanner scanner = new Scanner(System.in);
        final MenuFactory menuFactory = new MenuFactory(scanner, words, availableMistakesCount);
        final Menu menu = menuFactory.createMenu();

        menu.handleUserSelection();
        scanner.close();
    }

    private static Dictionary getDictionary() {
        final String wordsPath = "src/main/resources/Words.txt";
        return new Dictionary(wordsPath);
    }
}


