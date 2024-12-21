package org.proyecto.Class;
import org.proyecto.Interface.TDAplayer;

/**
 * Representacion del jugador con sus estadisticas.
 */
public class Player implements TDAplayer {
    /// Atributos.
    private int id;
    private String name;
    private String color;
    private int wins;
    private int losses;
    private int draws;
    private int remainingPieces;

    //---------------------------------------------------------//

    /// Getters.

    /**
     * Obtiene el nombre del jugador.
     * @return El nombre del jugador.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Obtiene el identificador del jugador.
     * @return El ID del jugador.
     */
    @Override
    public int getID() {
        return id;
    }

    /**
     * Obtiene el color del jugador.
     * @return El color del jugador.
     */
    @Override
    public String getColor() {
        return color;
    }

    /**
     * Obtiene el número de partidas ganadas por el jugador.
     * @return Número de partidas ganadas.
     */
    @Override
    public int getWins() {
        return wins;
    }

    /**
     * Obtiene el número de partidas perdidas por el jugador.
     * @return Número de partidas perdidas.
     */
    @Override
    public int getLosses() {
        return losses;
    }

    /**
     * Obtiene el número de partidas empatadas por el jugador.
     * @return Número de partidas empatadas.
     */
    @Override
    public int getDraws() {
        return draws;
    }

    /**
     * Obtiene el número de piezas restantes del jugador.
     * @return Número de piezas restantes.
     */
    @Override
    public int getRemainingPieces() {
        return remainingPieces;
    }

    //---------------------------------------------------------//

    /// Setters.

    /**
     * Establece el identificador del jugador.
     * @param id Nuevo ID del jugador.
     */
    @Override
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Establece el nombre del jugador.
     * @param name Nuevo nombre del jugador.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Establece el color del jugador.
     * @param color Nuevo color del jugador.
     */
    @Override
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Establece el número de partidas ganadas por el jugador.
     * @param wins Nuevo número de partidas ganadas.
     */
    @Override
    public void setWins(int wins) {
        this.wins = wins;
    }

    /**
     * Establece el número de partidas perdidas por el jugador.
     * @param losses Nuevo número de partidas perdidas.
     */
    @Override
    public void setLosses(int losses) {
        this.losses = losses;
    }

    /**
     * Establece el número de partidas empatadas por el jugador.
     * @param draws Nuevo número de partidas empatadas.
     */
    @Override
    public void setDraws(int draws) {
        this.draws = draws;
    }

    /**
     * Establece el número de piezas restantes del jugador.
     * @param remainingPieces Nuevo número de piezas restantes.
     */
    @Override
    public void setRemainingPieces(int remainingPieces) {
        this.remainingPieces = remainingPieces;
    }

    //---------------------------------------------------------//

    /**
     * RF03.
     * Constructor deL Player.
     * @param id Identificador del jugador.
     * @param name Nombre del jugador.
     * @param color Color del jugador.
     * @param wins Número de partidas ganadas por el jugador.
     * @param losses Número de partidas perdidas por el jugador.
     * @param draws Número de partidas empatadas por el jugador.
     * @param remainingPieces Número de piezas restantes del jugador.
     */
    public Player(int id, String name, String color, int wins, int losses, int draws, int remainingPieces) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.remainingPieces = remainingPieces;
    }
}