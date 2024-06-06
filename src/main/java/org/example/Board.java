package org.example;

public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    public void place(int x, int y, char maker) {  //maker plazieren
        if (isCellEmpty(x, y)) {
            cells[x][y] = maker;
        }
    }

    public void clear() {   //Spielfeld leeren
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + cells[i][j]);
            }
            System.out.println("|");
        }
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkForWin(char maker) {
        return (checkRowsForWin(maker) || checkColumnsForWin(maker) || checkDiagonalsForWin(maker));
    }

    private boolean checkRowsForWin(char maker) {
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == maker && cells[i][1] == maker && cells[i][2] == maker) {
                return true;
            }
        }
        return false;
    }

    public char[][] getCells() {
        return cells;
    }

    private boolean checkColumnsForWin(char maker) {
        for (int i = 0; i < 3; i++) {
            if (cells[0][i] == maker && cells[1][i] == maker && cells[2][i] == maker) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin(char maker) { //
        if (cells[0][0] == maker && cells[1][1] == maker && cells[2][2] == maker) {
            return true;
        }
        if (cells[0][2] == maker && cells[1][1] == maker && cells[2][0] == maker) {
            return true;
        }
        return false;
    }
}
