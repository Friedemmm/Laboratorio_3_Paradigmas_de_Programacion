package org.proyecto.Class;
import org.proyecto.Interface.TDApieceInterface_210821481_VergaraGodoy;

/**
 * Clase que representa una pieza del juego Conecta 4.
 * Implementa la interfaz TDApieceInterface_210821481_VergaraGodoy.
 * Cada pieza tiene un color asociado que la identifica con un jugador.
 *
 * @author Sofia Vergara Godoy
 * @version 1.0
 */
public class TDApieceClass_210821481_VergaraGodoy implements TDApieceInterface_210821481_VergaraGodoy {

    /// Atributos.

    /** Color asignado a la pieza */
    private String color;

    //---------------------------------------------------------//

    /// Getters.

    /**
     * Obtiene el color de la pieza.
     *
     * @return String que representa el color de la pieza
     */
    @Override
    public String getColor() {
        return color;
    }

    //---------------------------------------------------------//

    /**
     * RF04. Constructor que inicializa una nueva pieza con un color específico.
     *
     * @param color El color que se asignará a la pieza
     */
    public TDApieceClass_210821481_VergaraGodoy(String color) {
        this.color = color;
    }
}


