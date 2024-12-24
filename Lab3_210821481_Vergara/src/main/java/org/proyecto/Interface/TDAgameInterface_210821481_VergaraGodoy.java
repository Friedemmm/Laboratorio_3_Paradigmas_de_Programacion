package org.proyecto.Interface;
import org.proyecto.Class.TDAboardClass_210821481_VergaraGodoy;
import org.proyecto.Class.TDAplayerClass_210821481_VergaraGodoy;

/**
 * Interfaz que define el comportamiento de una partida de Conecta 4.
 * Establece los métodos necesarios para gestionar el flujo del juego,
 * los turnos y el estado de la partida.
 *
 * @author Sofia Vergara Godoy
 * @version 1.0
 */
public interface TDAgameInterface_210821481_VergaraGodoy {

    /// Getters.

    /**
     * Obtiene el número del turno actual.
     *
     * @return El número de turno actual
     */
    int getCurrentTurn();

    /// Setters.

    /**
     * Establece el número del turno actual.
     *
     * @param currentTurn El nuevo número de turno
     */
    void setCurrentTurn(int currentTurn);

    /// Métodos.

    /**
     * Registra y muestra el historial de movimientos.
     *
     * @param columna La columna donde se realizó el movimiento
     * @param color El color de la ficha jugada
     */
    void history(int columna, String color);

    /**
     * Verifica si el juego ha terminado en empate.
     *
     * @return true si hay empate, false en caso contrario
     */
    boolean esEmpate();

    /**
     * Actualiza las estadísticas de los jugadores al finalizar la partida.
     */
    void actualizarEstadisticas();

    /**
     * Determina qué jugador debe jugar en el turno actual.
     *
     * @return 1 si es el turno del jugador 1, 2 si es el turno del jugador 2
     */
    int getCurrentPlayer();

    /**
     * Muestra el estado actual del tablero.
     */
    void boardGetState();

    /**
     * Verifica si el juego ha terminado y actualiza las estadísticas si es necesario.
     *
     * @return true si el juego ha terminado, false en caso contrario
     */
    boolean endGame();

    /**
     * Permite a un jugador realizar un movimiento en el juego.
     *
     * @param player El jugador que realiza el movimiento
     * @param columna La columna donde se intenta colocar la ficha (0-6)
     * @return true si el movimiento se realizó exitosamente, false en caso contrario
     */
    boolean realizarMovimiento(TDAplayerClass_210821481_VergaraGodoy player, int columna);

}

