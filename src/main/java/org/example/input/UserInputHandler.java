package org.example.input;

import java.util.Scanner;

public abstract class UserInputHandler {
    protected final Scanner scanner;

    public UserInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public abstract char getInput();
}
