package org.proyecto.Class;

/**
 * Representacion del jugador con sus estadisticas.
 */
public class Player {
    // Atributos.
    private int id;
    private String name;
    private String color;
    private int wins;
    private int losses;
    private int draws;
    private int remainingPieces;

    //---------------------------------------------------------//

    // Getter.
    /**
     * Obtiene el nombre del jugador.
     * @return El nombre del jugador.
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene el identificador del jugador.
     * @return El ID del jugador.
     */
    public int getID() {
        return id;
    }

    /**
     * Obtiene el color del jugador.
     * @return El color del jugador.
     */
    public String getColor() {
        return color;
    }

    /**
     * Obtiene el número de partidas ganadas por el jugador.
     * @return Número de partidas ganadas.
     */
    public int getWins() {
        return wins;
    }

    /**
     * Obtiene el número de partidas perdidas por el jugador.
     * @return Número de partidas perdidas.
     */
    public int getLosses() {
        return losses;
    }

    /**
     * Obtiene el número de partidas empatadas por el jugador.
     * @return Número de partidas empatadas.
     */
    public int getDraws() {
        return draws;
    }

    /**
     * Obtiene el número de piezas restantes del jugador.
     * @return Número de piezas restantes.
     */
    public int getRemainingPieces() {
        return remainingPieces;
    }

    // Setter.
    /**
     * Establece el identificador del jugador.
     * @param id Nuevo ID del jugador.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece el nombre del jugador.
     * @param name Nuevo nombre del jugador.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Establece el color del jugador.
     * @param color Nuevo color del jugador.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Establece el número de partidas ganadas por el jugador.
     * @param wins Nuevo número de partidas ganadas.
     */
    public void setWins(int wins) {
        this.wins = wins;
    }

    /**
     * Establece el número de partidas perdidas por el jugador.
     * @param losses Nuevo número de partidas perdidas.
     */
    public void setLosses(int losses) {
        this.losses = losses;
    }

    /**
     * Establece el número de partidas empatadas por el jugador.
     * @param draws Nuevo número de partidas empatadas.
     */
    public void setDraws(int draws) {
        this.draws = draws;
    }

    /**
     * Establece el número de piezas restantes del jugador.
     * @param remainingPieces Nuevo número de piezas restantes.
     */
    public void setRemainingPieces(int remainingPieces) {
        this.remainingPieces = remainingPieces;
    }

    //---------------------------------------------------------//

    /**
     * RF03.
     * Constructor del player.
     * @param id Identificador del jugador.
     * @param name Nombre del jugador.
     * @param color  Color del jugador.
     * @param wins Número de partidas ganadas.
     * @param losses Número de partidas perdidas.
     * @param draws Número de partidas empatadas.
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