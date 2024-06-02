package org.example;
import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.currentPlayer = player1;
        this.board = new Board();
    }

    public void start() {
        board.clear();
        while (true) {
            board.print();
            int row, col;
            Scanner scanner = new Scanner(System.in);

            do {
                System.out.println("Aktueller Spieler: " + currentPlayer.getMaker());
                System.out.println("Zeile eingeben (0, 1 oder 2): ");
                row = scanner.nextInt();
                System.out.println("Spalte eingeben (0, 1 oder 2): ");
                col = scanner.nextInt();
            } while (!board.isCellEmpty(row, col));

            board.place(row, col, currentPlayer.getMaker());

            if (hasWinner()) {
                board.print();
                System.out.println("Spieler " + currentPlayer.getMaker() + " gewinnt!");
                break;
            } else if (board.isFull()) {
                board.print();
                System.out.println("Das Spiel endet unentschieden!");
                break;
            } else {
                switchCurrentPlayer();
            }
        }
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        return board.checkForWin(currentPlayer.getMaker());
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}
