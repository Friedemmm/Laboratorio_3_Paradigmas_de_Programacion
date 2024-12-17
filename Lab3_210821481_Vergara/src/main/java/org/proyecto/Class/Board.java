package org.proyecto.Class;

public class Board {
    private int[][] board;

    // Constructor
    public Board() {
        board = new int[6][7]; // 6 filas y 7 columnas
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = 0;
            }
        }
    }

    // Getter
    public int[][] getBoard() {
        return board;
    }

    // Setter
    public void setBoard(int[][] board) {
        this.board = board;
    }
}
