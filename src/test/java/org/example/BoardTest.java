package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    // Tests for isCellEmpty
    @Test
    public void testIsCellEmpty() {
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsCellNotEmpty() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    // Tests for place
    @Test
    public void testPlaceMarker() {
        board.place(0, 0, 'X');
        assertEquals('X', board.getCells()[0][0]);
    }

    @Test
    public void testPlaceMarkerOnNonEmptyCell() {
        board.place(0, 0, 'X');
        board.place(0, 0, 'O');
        assertNotEquals('O', board.getCells()[0][0]); // should not change
    }

    // Tests for clear
    @Test
    public void testClearBoard() {
        board.place(0, 0, 'X');
        board.clear();
        assertEquals(' ', board.getCells()[0][0]);
    }

    @Test
    public void testClearBoardMultipleCells() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        board.clear();
        assertEquals(' ', board.getCells()[0][0]);
        assertEquals(' ', board.getCells()[1][1]);
    }

    // Tests for checkForWin
    @Test
    public void testWinConditionsRow() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');
        assertTrue(board.checkForWin('X'));
    }

    @Test
    public void testNoWinConditions() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(1, 1, 'X');
        assertFalse(board.checkForWin('X'));
    }

    // Tests for isFull
    @Test
    public void testIsFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testIsNotFull() {
        board.place(0, 0, 'X');
        assertFalse(board.isFull());
    }
}