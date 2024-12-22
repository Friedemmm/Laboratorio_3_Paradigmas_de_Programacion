package org.proyecto.Interface;
import org.proyecto.Class.Board;
import org.proyecto.Class.Player;
import java.util.List;

public interface TDAgame {
    /// Getters.
    Player getPlayer1();
    Player getPlayer2();
    Board getBoard();
    int getCurrentTurn();
    List<String> getHistorial();

    /// Setters.
    void setPlayer1(Player player1);
    void setPlayer2(Player player2);
    void setBoard(Board board);
    void setCurrentTurn(int currentTurn);
    void setHistorial(List<String> historial);

    /// Métodos.
    void history(int columna, String color);
    boolean esEmpate();
    void actualizarEstadisticas();
    int getCurrentPlayer();
    void boardGetState();

}

