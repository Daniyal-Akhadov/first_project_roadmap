package org.example;

import org.example.parser.FileReader;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

public class Dictionary {
    private final List<String> words;

    public Dictionary(String path) {
        words = getWordsFromFile(path);
    }

    public List<String> getWords() {
        return words;
    }

    private List<String> getWordsFromFile(final String path) {
        List<String> result = Collections.emptyList();

        try {
            result = readFile(path);
        } catch (FileNotFoundException exception) {
            logError(exception);
        }

        return result;
    }

    private List<String> readFile(final String path) throws FileNotFoundException {
        final FileReader fileReader = new FileReader(path);
        return fileReader.getWords();
    }

    private static void logError(FileNotFoundException exception) {
        System.out.println("\nФайл со словарём не был найден!\n" + exception.getMessage());
    }
}
