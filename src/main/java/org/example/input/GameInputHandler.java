package org.example.input;

import java.util.Scanner;

public class GameInputHandler extends UserInputHandler {
    public GameInputHandler(Scanner scanner) {
        super(scanner);
    }

    @Override
    public char getInput() {
        char result;

        while (true) {
            System.out.print("Напишите букву в слове: ");
            boolean isNextInputNumber = scanner.hasNextInt();
            String input = scanner.next();

            if (isNextInputNumber == false && input.length() == 1) {
                result = input.charAt(0);
                break;
            } else {
                System.out.println("\nНеправильный ввод. Пожалуйста, введите один буквенный символ.\n");
            }
        }

        return result;
    }
}
