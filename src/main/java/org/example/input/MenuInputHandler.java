package org.example.input;

import org.example.menu.Options;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuInputHandler extends UserInputHandler {

    public MenuInputHandler(Scanner scanner) {
        super(scanner);
    }

    @Override
    public char getInput() {
        char result;

        while (true) {
            try {
                printOptions();
                System.out.print("\nВаш ответ: ");
                result = (char) (scanner.nextInt() + '0');
                break;
            } catch (NumberFormatException | InputMismatchException exception) {
                System.out.println("\nОтвет некорректный!\n");
                scanner.next();
            }
        }

        return result;
    }

    public void printOptions() {
        System.out.printf("%d. начать игру\n", Options.START);
        System.out.printf("%d. выйти\n", Options.EXIT);
    }
}


