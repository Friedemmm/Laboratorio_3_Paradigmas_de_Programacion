package org.proyecto.Class;
import org.proyecto.Interface.TDAboard;

/**
 * Representa el tablero de 6 filas y 7 columnas.
 */
public class Board implements TDAboard {
    /// Atributos.
    private int[][] board;
    private Player player1;
    private Player player2;

    //---------------------------------------------------------//

    /// Getters.

    /**
     * Obtiene el tablero actual.
     * @return La matriz que representa el tablero.
     */
    @Override
    public int[][] getBoard() {
        return board;
    }

    //---------------------------------------------------------//

    /// Setters.

    /**
     * Establece un nuevo tablero.
     * @param board Una matriz de enteros que reemplazará el tablero actual.
     */
    @Override
    public void setBoard(int[][] board) {
        this.board = board;
    }

    /**
     * Establece los jugadores registrados en el juego.
     * @param player1 El primer jugador.
     * @param player2 El segundo jugador.
     */
    @Override
    public void setPlayers(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
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
     * Revisa la primera fila (arriba hacia abajo).
     */
    @Override
    public boolean sePuedeJugar() {
        for (int j = 0; j < 7; j++) {
            if (board[0][j] == 0) {
                return true; // Si se puede jugar.
            }
        }
        return false; // No se puede jugar.
    }

    /**
     * RF07.
     * Juega una ficha en la columna seleccionada.
     * @param columna La columna seleccionada para jugar.
     * @param pieza El número del jugador que va a jugar.
     */
    @Override
    public void jugarFicha(int columna, Piece pieza) {
        int jugadorFichaID;
        String colorPieza = pieza.getColor();
        String colorPlayer1 = player1.getColor();

        // Determinar qué número poner según el color.
        if (colorPieza.equals(colorPlayer1)) {
            jugadorFichaID = player1.getID(); // Si es el color de jugador 1 es igual, se pone 1.
        }
        else {
            jugadorFichaID = player2.getID(); // Si es el color de jugador 2 es igual, se pone 2.
        }

        // Colocar la ficha.
        for (int fila = 5; fila >= 0; fila--) {
            if (board[fila][columna] == 0) {
                board[fila][columna] = jugadorFichaID;
                break;
            }
        }
    }

    /**
     * RF08.
     * Verifica si hay una victoria vertical (4 fichas en columna).
     * @return El número del jugador ganador (1 o 2), o 0 si no hay ganador.
     */
    @Override
    public int verificarVictoriaVertical() {
        // Recorrer cada columna.
        for (int j = 0; j < 7; j++) {
            // Recorrer cada fila, pero solo hasta donde podamos tener 4 en línea.
            for (int i = 0; i <= 2; i++) {
                // Sí encontramos una ficha.
                if (board[i][j] != 0) {
                    // Verificar si hay 4 consecutivas.
                    if (board[i][j] == board[i + 1][j] && board[i][j] == board[i + 2][j] && board[i][j] == board[i + 3][j]) {
                        return board[i][j]; // Retorna el jugador.
                    }
                }
            }
        }
        return 0; // No hay ganador vertical.
    }

    /**
     * RF09.
     * Verifica si hay una victoria horizontal (4 fichas en fila).
     * @return el número del jugador ganador (1 o 2), o 0 si no hay ganador.
     */
    @Override
    public int verificarVictoriaHorizontal() {
        // Recorrer cada fila.
        for (int i = 0; i < 6; i++) {
            // Recorrer cada columna, pero solo hasta donde podamos tener 4 en línea.
            for (int j = 0; j <= 3; j++) {
                // Si encontramos una ficha.
                if (board[i][j] != 0) {
                    // Verificar si hay 4 consecutivas.
                    if (board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2] && board[i][j] == board[i][j + 3]) {
                        return board[i][j]; // Retorna el jugador.
                    }
                }
            }
        }
        return 0; // No hay ganador horizontal.
    }

    /**
     * RF10.
     * Verifica si hay una victoria diagonal (4 fichas en diagonal).
     * @return el número del jugador ganador (1 o 2), o 0 si no hay ganador.
     */
    @Override
    public int verificarVictoriaDiagonal() {
        // Verificar diagonales descendentes.
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 3; j++) {
                if (board[i][j] != 0) {
                    if (board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j + 2] && board[i][j] == board[i + 3][j + 3]) {
                        return board[i][j];
                    }
                }
            }
        }

        // Verificar diagonales ascendentes.
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j <= 3; j++) {
                if (board[i][j] != 0) {
                    if (board[i][j] == board[i - 1][j + 1] && board[i][j] == board[i - 2][j + 2] && board[i][j] == board[i - 3][j + 3]) {
                        return board[i][j];
                    }
                }
            }
        }

        return 0; // No hay ganador diagonal.
    }

    /**
     * RF11.
     * Verifica todas las formas de ganar.
     * @return el número del jugador ganador (1 o 2), o 0 si no hay ganador.
     */
    @Override
    public int entregarGanador() {
        // Verificar victoria vertical.
        int ganadorVertical = verificarVictoriaVertical();
        if (ganadorVertical != 0) {
            return ganadorVertical;
        }

        // Verificar victoria horizontal.
        int ganadorHorizontal = verificarVictoriaHorizontal();
        if (verificarVictoriaHorizontal() != 0) {
            return ganadorHorizontal;
        }

        // Verificar victoria diagonal.
        int ganadorDiagonal = verificarVictoriaDiagonal();
        if (ganadorDiagonal != 0) {
            return ganadorDiagonal;
        }

        // Si no hay ganador.
        return 0;
    }


}


