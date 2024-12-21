package org.proyecto.Interface;
import org.proyecto.Class.Piece;
import org.proyecto.Class.Player;

public interface TDAboard {
    /// Getters.
    int[][] getBoard();

    /// Setters.
    void setBoard(int[][] board);
    void setPlayers(Player player1, Player player2);

    /// Métodos.
    boolean sePuedeJugar();
    void jugarFicha(int columna, Piece pieza);
    int verificarVictoriaVertical();
    int verificarVictoriaHorizontal();
    int verificarVictoriaDiagonal();
    int entregarGanador();

}
