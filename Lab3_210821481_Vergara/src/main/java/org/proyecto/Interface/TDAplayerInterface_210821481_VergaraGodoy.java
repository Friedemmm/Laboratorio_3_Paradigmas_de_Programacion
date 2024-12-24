package org.proyecto.Interface;

/**
 * Interfaz que define el comportamiento de un jugador en el juego Conecta 4.
 * Establece los métodos necesarios para gestionar la información y estadísticas
 * de un jugador.
 *
 * @author Sofia Vergara Godoy
 * @version 1.0
 */
public interface TDAplayerInterface_210821481_VergaraGodoy {

    /// Getters.

    /**
     * Obtiene el nombre del jugador.
     *
     * @return El nombre del jugador
     */
    String getName();

    /**
     * Obtiene el identificador único del jugador.
     *
     * @return El ID del jugador
     */
    int getID();

    /**
     * Obtiene el color asignado al jugador.
     *
     * @return El color del jugador
     */
    String getColor();

    /**
     * Obtiene el número de partidas ganadas.
     *
     * @return La cantidad de victorias del jugador
     */
    int getWins();

    /**
     * Obtiene el número de partidas perdidas.
     *
     * @return La cantidad de derrotas del jugador
     */
    int getLosses();

    /**
     * Obtiene el número de partidas empatadas.
     *
     * @return La cantidad de empates del jugador
     */
    int getDraws();

    /**
     * Obtiene el número de fichas restantes.
     *
     * @return La cantidad de fichas disponibles para jugar
     */
    int getRemainingPieces();

    /// Setters.

    /**
     * Actualiza el número de partidas ganadas.
     *
     * @param wins Nueva cantidad de victorias
     */
    void setWins(int wins);

    /**
     * Actualiza el número de partidas perdidas.
     *
     * @param losses Nueva cantidad de derrotas
     */
    void setLosses(int losses);

    /**
     * Actualiza el número de partidas empatadas.
     *
     * @param draws Nueva cantidad de empates
     */
    void setDraws(int draws);

    /**
     * Actualiza el número de fichas restantes.
     *
     * @param remainingPieces Nueva cantidad de fichas disponibles
     */
    void setRemainingPieces(int remainingPieces);
}
