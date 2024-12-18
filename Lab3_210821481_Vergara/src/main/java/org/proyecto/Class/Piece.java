package org.proyecto.Class;

/**
 * Representa una pieza de color en el juego.
 */
public class Piece {
    // Atributo.
    private String color;

    //---------------------------------------------------------//

    // Getter.
    /**
     * Obtiene el color de la pieza.
     * @return El color de la pieza.
     */
    public String getColor() {
        return color;
    }

    // Setter.
    /**
     * Establece el color de la pieza.
     * @param color El nuevo color que se asignará a la pieza.
     */
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


