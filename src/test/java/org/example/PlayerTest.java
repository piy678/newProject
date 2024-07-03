package org.example;

import org.example.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void testPlayerConstructorPositive() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker(), "The marker should be 'X'");
    }

    @Test
    public void testPlayerConstructorPositiveDifferentMarker() {
        Player player = new Player('O');
        assertEquals('O', player.getMarker(), "The marker should be 'O'");
    }

    @Test
    public void testPlayerConstructorNegative() {
        Player player = new Player('X');
        assertNotEquals('O', player.getMarker(), "The marker should not be 'O'");
    }

    @Test
    public void testPlayerConstructorInvalidMarker() {

        Player player = new Player('A');
        assertEquals('A', player.getMarker(), "The marker should be 'A', even though it's not a typical marker in Tic Tac Toe");
    }
    @Test
    public void testPlayerGetMarker() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());

        player = new Player('O');
        assertEquals('O', player.getMarker());
    }

    @Test
    public void testPlayerGetMarkerNegative() {
        Player player = new Player('X');
        assertNotEquals('O', player.getMarker());

        player = new Player('O');
        assertNotEquals('X', player.getMarker());
    }
}