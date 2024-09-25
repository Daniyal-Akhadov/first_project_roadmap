package org.example.parser;

import org.example.utils.ImmutableArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Dictionary {

    private static final String FILE_PATH = "src/main/resources/Words.txt";

    public ImmutableArray<String> getWords() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(FILE_PATH));
        List<String> list = new ArrayList<>();

        while (scanner.hasNext()) {
            list.add(scanner.next());
        }

        String[] array = list.toArray(new String[0]);
        scanner.close();

        return new ImmutableArray<>(array);
    }
}
