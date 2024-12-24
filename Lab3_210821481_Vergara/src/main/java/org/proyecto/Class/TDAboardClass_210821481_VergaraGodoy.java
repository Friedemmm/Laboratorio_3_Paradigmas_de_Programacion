package org.proyecto.Class;
import org.proyecto.Interface.TDAboardInterface_210821481_VergaraGodoy;

/**
 * Clase que representa el tablero del juego Conecta 4.
 * Implementa la interfaz TDAboardInterface_210821481_VergaraGodoy.
 * Mantiene el estado del tablero y provee métodos para manipularlo y verificar victorias.
 *
 * @author Sofia Vergara Godoy.
 * @version 1.0
 */
public class TDAboardClass_210821481_VergaraGodoy implements TDAboardInterface_210821481_VergaraGodoy {

    /// Atributos.

    /** Matriz que representa el estado del tablero */
    private int[][] board;
    /** Referencia al primer jugador */
    private TDAplayerClass_210821481_VergaraGodoy player1;
    /** Referencia al segundo jugador */
    private TDAplayerClass_210821481_VergaraGodoy player2;

    //---------------------------------------------------------//

    /// Getters.

    /**
     * Obtiene el estado actual del tablero.
     * @return Una matriz de enteros que representa el estado actual del tablero,
     *         donde 0 representa una casilla vacía, 1 representa una ficha del jugador 1,
     *         y 2 representa una ficha del jugador 2.
     */
    @Override
    public int[][] getBoard() {
        return board;
    }

    //---------------------------------------------------------//

    /// Setters.

    /**
     * Establece los jugadores que participarán en el juego.
     * @param player1 El primer jugador.
     * @param player2 El segundo jugador.
     */
    @Override
    public void setPlayers(TDAplayerClass_210821481_VergaraGodoy player1, TDAplayerClass_210821481_VergaraGodoy player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    //---------------------------------------------------------//

    /**
     * RF05. Constructor que inicializa un nuevo tablero vacío.
     * Crea una matriz de 6x7 inicializada con ceros.
     */
    public TDAboardClass_210821481_VergaraGodoy() {
        board = new int[6][7]; // 6 filas y 7 columnas
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = 0;
            }
        }
    }

    /**
     * RF06. Verifica si aún es posible realizar jugadas en el tablero.
     * @return true si hay al menos una columna con espacio disponible, false en caso contrario.
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
     * RF07. Intenta colocar una ficha en la columna especificada.
     * @param columna La columna donde se intentará colocar la ficha (0-6).
     * @param pieza La pieza que se intentará colocar.
     * @return true si la ficha se colocó exitosamente, false si la columna está llena.
     */
    @Override
    public boolean jugarFicha(int columna, TDApieceClass_210821481_VergaraGodoy pieza) {
        // Verificar si la columna está llena
        if (board[0][columna] != 0) {
            System.out.println("Columna llena. Por favor elija otra columna.");
            return false;
        }

        int jugadorFichaID;
        String colorPieza = pieza.getColor();
        String colorPlayer1 = player1.getColor();

        // Determinar qué número poner según el color.
        if (colorPieza.equals(colorPlayer1)) {
            jugadorFichaID = player1.getID();
        }
        else {
            jugadorFichaID = player2.getID();
        }

        // Colocar la ficha.
        for (int fila = 5; fila >= 0; fila--) {
            if (board[fila][columna] == 0) {
                board[fila][columna] = jugadorFichaID;
                return true;
            }
        }
        return false;
    }

    /**
     * RF08. Verifica si hay una victoria vertical (4 fichas en línea verticalmente).
     * @return El número del jugador ganador (1 o 2), o 0 si no hay victoria vertical.
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
     * RF09. Verifica si hay una victoria horizontal (4 fichas en línea horizontalmente).
     * @return El número del jugador ganador (1 o 2), o 0 si no hay victoria horizontal.
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
     * RF10. Verifica si hay una victoria diagonal (4 fichas en línea diagonalmente).
     * Comprueba tanto diagonales ascendentes como descendentes.
     * @return El número del jugador ganador (1 o 2), o 0 si no hay victoria diagonal.
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
     * RF11. Verifica si hay un ganador en cualquier dirección.
     * @return El número del jugador ganador (1 o 2), o 0 si no hay ganador.
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


