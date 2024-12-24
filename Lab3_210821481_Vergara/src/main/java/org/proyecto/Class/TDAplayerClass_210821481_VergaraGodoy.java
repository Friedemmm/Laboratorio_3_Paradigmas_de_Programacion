package org.proyecto.Class;
import org.proyecto.Interface.TDAplayerInterface_210821481_VergaraGodoy;

/**
 * Clase que representa a un jugador en el juego Conecta 4.
 * Implementa la interfaz TDAplayerInterface_210821481_VergaraGodoy.
 * Mantiene el registro de las estadísticas del jugador y su información básica.
 *
 * @author Sofia Vergara Godoy
 * @version 1.0
 */
public class TDAplayerClass_210821481_VergaraGodoy implements TDAplayerInterface_210821481_VergaraGodoy {

    /// Atributos.

    /** Identificador único del jugador */
    private int id;
    /** Nombre del jugador */
    private String name;
    /** Color asignado al jugador para sus fichas */
    private String color;
    /** Número de partidas ganadas */
    private int wins;
    /** Número de partidas perdidas */
    private int losses;
    /** Número de partidas empatadas */
    private int draws;
    /** Número de fichas restantes del jugador */
    private int remainingPieces;

    //---------------------------------------------------------//

    /// Getters.

    /**
     * Obtiene el nombre del jugador.
     *
     * @return El nombre del jugador
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Obtiene el identificador único del jugador.
     *
     * @return El ID del jugador
     */
    @Override
    public int getID() {
        return id;
    }

    /**
     * Obtiene el color asignado al jugador.
     *
     * @return El color del jugador para sus fichas
     */
    @Override
    public String getColor() {
        return color;
    }

    /**
     * Obtiene el número de partidas ganadas por el jugador.
     *
     * @return La cantidad de victorias del jugador
     */
    @Override
    public int getWins() {
        return wins;
    }

    /**
     * Obtiene el número de partidas perdidas por el jugador.
     *
     * @return La cantidad de derrotas del jugador
     */
    @Override
    public int getLosses() {
        return losses;
    }

    /**
     * Obtiene el número de partidas empatadas por el jugador.
     *
     * @return La cantidad de empates del jugador
     */
    @Override
    public int getDraws() {
        return draws;
    }

    /**
     * Obtiene el número de fichas restantes del jugador.
     *
     * @return La cantidad de fichas disponibles para jugar
     */
    @Override
    public int getRemainingPieces() {
        return remainingPieces;
    }

    //---------------------------------------------------------//

    /// Setters.

    /**
     * Actualiza el número de partidas ganadas por el jugador.
     *
     * @param wins Nueva cantidad de victorias
     */
    @Override
    public void setWins(int wins) {
        this.wins = wins;
    }

    /**
     * Actualiza el número de partidas perdidas por el jugador.
     *
     * @param losses Nueva cantidad de derrotas
     */
    @Override
    public void setLosses(int losses) {
        this.losses = losses;
    }

    /**
     * Actualiza el número de partidas empatadas por el jugador.
     *
     * @param draws Nueva cantidad de empates
     */
    @Override
    public void setDraws(int draws) {
        this.draws = draws;
    }

    /**
     * Actualiza el número de fichas restantes del jugador.
     *
     * @param remainingPieces Nueva cantidad de fichas disponibles
     */
    @Override
    public void setRemainingPieces(int remainingPieces) {
        this.remainingPieces = remainingPieces;
    }

    //---------------------------------------------------------//

    /**
     * RF03. Constructor que inicializa un nuevo jugador con sus estadísticas iniciales.
     *
     * @param id Identificador único del jugador
     * @param name Nombre del jugador
     * @param color Color asignado al jugador para sus fichas
     * @param wins Número inicial de victorias
     * @param losses Número inicial de derrotas
     * @param draws Número inicial de empates
     * @param remainingPieces Número inicial de fichas disponibles
     */
    public TDAplayerClass_210821481_VergaraGodoy(int id, String name, String color, int wins, int losses, int draws, int remainingPieces) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.remainingPieces = remainingPieces;
    }
}