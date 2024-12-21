package org.proyecto.Class;
import org.proyecto.Interface.TDApiece;

/**
 * Representa una pieza de color en el juego.
 */
public class Piece implements TDApiece {
    /// Atributos.
    private String color;

    //---------------------------------------------------------//

    /// Getters.

    /**
     * Obtiene el color de la pieza.
     * @return El color de la pieza.
     */
    @Override
    public String getColor() {
        return color;
    }

    //---------------------------------------------------------//

    /// Setters.

    /**
     * Establece el color de la pieza.
     * @param color El nuevo color que se asignará a la pieza.
     */
    @Override
    public void setColor(String color) {
        this.color = color;
    }

    //---------------------------------------------------------//

    /**
     * RF04.
     * Constructor de la pieza.
     * @param color El color asociado a la pieza.
     */
    public Piece(String color) {
        this.color = color;
    }
}


