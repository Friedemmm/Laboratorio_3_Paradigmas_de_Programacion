package org.proyecto.Class;

/**
 * Representa el tablero de 6 filas y 7 columnas.
 */
public class Board {
    // Atributo.
    private int[][] board;

    //---------------------------------------------------------//

    /**
     * Obtiene el tablero actual.
     * @return La matriz que representa el tablero.
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * Establece un nuevo tablero.
     * @param board Una matriz de enteros que reemplazará el tablero actual.
     */
    public void setBoard(int[][] board) {
        this.board = board;
    }

    //---------------------------------------------------------//

    /**
     * RF05.
     * Constructor del board.
     */
    public Board() {
        board = new int[6][7]; // 6 filas y 7 columnas
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = 0;
            }
        }
    }

    /**
     * RF06.
     * Verifica si se puede jugar en el tablero.
     * @return {@code true} si hay al menos una columna con espacio disponible sino {@code false}.
     */
    public boolean sePuedeJugar() {
        for (int j = 0; j < 7; j++) {
            if (board[0][j] == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * RF07.
     * Juegar una ficha en la columna seleccionada.
     * @param columna La columna seleccionada para jugar.
     * @param jugador El número del jugador que va a jugar.
     */
    public void jugarFicha(int columna, int jugador) {

        // Validar que el jugador sea válido (1 o 2)
        if (jugador != 1 && jugador != 2) {
            System.out.println("Jugador no válido");
            return;
        }

        // Validar que la columna sea válida
        if (columna < 0 || columna >= 7) {
            System.out.println("Columna no válida");
            return;
        }

        // Encontrar la primera posición disponible desde abajo
        for (int fila = 5; fila >= 0; fila--) {
            if (board[fila][columna] == 0) {
                board[fila][columna] = jugador;
                break;
            }
        }
    }


}
