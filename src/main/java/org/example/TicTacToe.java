package org.example;

import org.example.Player;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TicTacToe {
    Player player1;
    Player player2;
    Player currentPlayer;
    Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        board.clear();
        currentPlayer = player1;
        boolean gameWon = false;
        Scanner scanner = new Scanner(System.in);

        while (!board.isFull() && !gameWon) {
            board.print();
            System.out.println("Player " + currentPlayer.getMarker() + ", enter your move (row and column): ");

            try {

                if (scanner.hasNextLine()) {
                    int row = scanner.nextInt();
                    int col = scanner.nextInt();

                    if (row < 0 || row >= 3 || col < 0 || col >= 3 || !board.isCellEmpty(row, col)) {
                        System.out.println("This move is not valid");
                    } else {
                        board.place(row, col, currentPlayer.getMarker());
                        if (hasWinner()) {
                            board.print();
                            System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                            gameWon = true;
                        } else {
                            switchCurrentPlayer();
                        }
                    }
                } else {

                    System.out.println("No input received. Please provide valid input.");
                    scanner.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter two integers for row and column.");
                scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Input error. Please provide valid input.");
                scanner.nextLine();
            }
        }

        if (!gameWon) {
            board.print();
            System.out.println("The game is a draw!");
        }

        scanner.close();
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        char[][] cells = board.cells;

        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2] && cells[i][0] != ' ') ||
                    (cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i] && cells[0][i] != ' ')) {
                return true;
            }
        }

        // Check diagonals
        if ((cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2] && cells[0][0] != ' ') ||
                (cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0] && cells[0][2] != ' ')) {
            return true;
        }

        return false;
    }
}