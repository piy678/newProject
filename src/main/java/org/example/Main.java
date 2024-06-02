package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        boolean playAgain;
        Scanner scanner = new Scanner(System.in);

        do {
            game.start();
            System.out.print("Möchten Sie erneut spielen? (ja/nein): ");
            playAgain = scanner.next().equalsIgnoreCase("ja");
        } while (playAgain);

        scanner.close();
    }
}
