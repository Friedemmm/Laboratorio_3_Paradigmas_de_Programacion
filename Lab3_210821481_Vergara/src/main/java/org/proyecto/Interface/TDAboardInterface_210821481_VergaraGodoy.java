package org.proyecto.Interface;
import org.proyecto.Class.TDApieceClass_210821481_VergaraGodoy;
import org.proyecto.Class.TDAplayerClass_210821481_VergaraGodoy;

/**
 * Interfaz que define el comportamiento de un tablero de Conecta 4.
 * Establece los métodos necesarios para manipular el estado del tablero
 * y verificar las condiciones de victoria.
 *
 * @author Sofia Vergara Godoy
 * @version 1.0
 */
public interface TDAboardInterface_210821481_VergaraGodoy {

    /// Getters.

    /**
     * Obtiene el estado actual del tablero.
     *
     * @return Matriz de enteros que representa el tablero, donde 0 es una celda vacía,
     *         1 representa una ficha del jugador 1, y 2 una ficha del jugador 2
     */
    int[][] getBoard();

    /// Setters.

    /**
     * Establece los jugadores que participarán en el juego.
     *
     * @param player1 El primer jugador
     * @param player2 El segundo jugador
     */
    void setPlayers(TDAplayerClass_210821481_VergaraGodoy player1, TDAplayerClass_210821481_VergaraGodoy player2);

    /// Métodos.

    /**
     * Verifica si es posible realizar más jugadas en el tablero.
     *
     * @return true si hay al menos una columna disponible para jugar,
     *         false si el tablero está completamente lleno
     */
    boolean sePuedeJugar();

    /**
     * Intenta colocar una ficha en la columna especificada.
     *
     * @param columna Indice de la columna donde se intentará colocar la ficha (0-6)
     * @param pieza La pieza que se intentará colocar
     * @return true si la ficha se colocó exitosamente, false si la columna está llena
     */
    boolean jugarFicha(int columna, TDApieceClass_210821481_VergaraGodoy pieza);

    /**
     * Verifica si hay una victoria vertical (4 en línea en columna).
     *
     * @return El número del jugador ganador (1 o 2), o 0 si no hay victoria vertical
     */
    int verificarVictoriaVertical();

    /**
     * Verifica si hay una victoria horizontal (4 en línea en fila).
     *
     * @return El número del jugador ganador (1 o 2), o 0 si no hay victoria horizontal
     */
    int verificarVictoriaHorizontal();

    /**
     * Verifica si hay una victoria diagonal (4 en línea en diagonal).
     *
     * @return El número del jugador ganador (1 o 2), o 0 si no hay victoria diagonal
     */
    int verificarVictoriaDiagonal();

    /**
     * Determina si hay un ganador en cualquier dirección.
     *
     * @return El número del jugador ganador (1 o 2), o 0 si no hay ganador
     */
    int entregarGanador();

}
