package org.example.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class FileReader {

    private final String FILE_PATH ;

    public FileReader(String filePath) {
        FILE_PATH = filePath;
    }

    public List<String> getWords() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(FILE_PATH));
        List<String> list = new ArrayList<>();

        while (scanner.hasNext()) {
            list.add(scanner.next());
        }

        scanner.close();
        return list;
    }
}
