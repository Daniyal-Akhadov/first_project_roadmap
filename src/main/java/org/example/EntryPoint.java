package org.example;

import java.util.Scanner;

public final class EntryPoint {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Launcher launcher = new Launcher(scanner);

        launcher.askUser();
        scanner.close();
    }
}


