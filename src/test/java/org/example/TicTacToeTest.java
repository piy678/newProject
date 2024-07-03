package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testConstructorInitialization() {
        assertNotNull(game.player1);
        assertNotNull(game.player2);
        assertNotNull(game.currentPlayer);
        assertNotNull(game.board);

        assertEquals('X', game.player1.getMarker());
        assertEquals('O', game.player2.getMarker());
        assertEquals(game.player1, game.currentPlayer);
        assertFalse(game.board.isFull());
    }

    @Test
    public void testGamePlayWithValidMoves() {
        String input = "0 0\n0 1\n1 1\n0 2\n2 2\n";
        simulateUserInput(input);
        assertDoesNotThrow(() -> game.start());

        assertTrue(game.hasWinner());
        assertEquals(game.player1, game.currentPlayer);
    }

    @Test
    public void testGamePlayWithInvalidMoves() {
        String input = "-1 1\n3 3\n0 0\n0 0\n";
        simulateUserInput(input);

        Assertions.assertThrows(NoSuchElementException.class, () -> game.start());


        assertEquals(game.board.isFull(), false, "Das Spielbrett sollte nicht voll sein");
        assertFalse(game.hasWinner(), "Es sollte keinen Gewinner geben");
    }

    @Test
    public void testConstructorWithInvalidParameters() {
        assertDoesNotThrow(() -> new TicTacToe());
    }

    @Test
    public void testSwitchCurrentPlayer() {
        assertEquals('X', game.currentPlayer.getMarker());
        game.switchCurrentPlayer();
        assertEquals('O', game.currentPlayer.getMarker());
    }

    @Test
    public void testSwitchCurrentPlayerTwice() {
        game.switchCurrentPlayer();
        game.switchCurrentPlayer();
        assertEquals('X', game.currentPlayer.getMarker());
    }

    @Test
    public void testHasWinner() {
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(0, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testNoWinner() {
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(0, 2, 'O');
        assertFalse(game.hasWinner());
    }

    private void simulateUserInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
