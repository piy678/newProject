package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
    }

    // Tests for switchCurrentPlayer
    @Test
    public void testSwitchCurrentPlayer() {
        game.switchCurrentPlayer();
        assertEquals('O', game.getCurrentPlayer().getMaker());
        game.switchCurrentPlayer();
        assertEquals('X', game.getCurrentPlayer().getMaker());
    }

    @Test
    public void testSwitchCurrentPlayerNotEquals() {
        game.switchCurrentPlayer();
        assertNotEquals('X', game.getCurrentPlayer().getMaker());
        game.switchCurrentPlayer();
        assertNotEquals('O', game.getCurrentPlayer().getMaker());
    }

    // Tests for hasWinner
    @Test
    public void testHasWinnerPositive() {
        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'X');
        game.getBoard().place(0, 2, 'X');
        assertTrue(game.hasWinner());
    }

    @Test
    public void testHasWinnerNegative() {
        game.getBoard().place(0, 0, 'X');
        game.getBoard().place(0, 1, 'X');
        game.getBoard().place(1, 1, 'X');
        assertFalse(game.hasWinner());
    }

    // Tests for getCurrentPlayer
    @Test
    public void testGetCurrentPlayerInitial() {
        assertEquals('X', game.getCurrentPlayer().getMaker());
    }

    @Test
    public void testGetCurrentPlayerAfterSwitch() {
        game.switchCurrentPlayer();
        assertEquals('O', game.getCurrentPlayer().getMaker());
    }

    @Test
    public void testGetCurrentPlayerNotEquals() {
        assertNotEquals('O', game.getCurrentPlayer().getMaker());
        game.switchCurrentPlayer();
        assertNotEquals('X', game.getCurrentPlayer().getMaker());
    }
    public void testIsValidMovePositive() {
        assertTrue(game.isValidMove(0, 0));
        game.getBoard().place(0, 0, 'X');
        assertFalse(game.isValidMove(0, 0));
    }

    @Test
    public void testIsValidMoveNegative() {
        assertFalse(game.isValidMove(3, 0));
        assertFalse(game.isValidMove(-1, 0));
        assertFalse(game.isValidMove(0, 3));
        assertFalse(game.isValidMove(0, -1));
    }
}