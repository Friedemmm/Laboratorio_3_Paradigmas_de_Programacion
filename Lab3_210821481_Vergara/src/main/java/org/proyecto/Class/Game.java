package org.proyecto.Class;
import org.proyecto.Class.Board;

import java.util.ArrayList;
import java.util.List;

public class Game {
    // Atributos.
    private Player player1;
    private Player player2;
    private Board board;
    private int currentTurn;
    private List<String> moveHistory;

    //---------------------------------------------------------//

    // Getter.
    /**
     * Obtiene el jugador 1.
     * @return El jugador 1.
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Obtiene el jugador 2.
     * @return El jugador 2.
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Obtiene el board del juego.
     * @return El board del juego.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Obtiene la cantidad de turnos que llevan.
     * @return La cantidad de turnos que llevan.
     */
    public int getCurrentTurn() {
        return currentTurn;
    }

    /**
     * Obtiene el historial de movimientos del juego.
     * @return La lista de movimientos realizada en el juego.
     */
    public List<String> getMoveHistory() {
        return moveHistory;
    }

    // Setter.
    /**
     * Establece el jugador 1.
     *
     * @param player1 El jugador 1.
     */
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    /**
     * Establece el jugador 2.
     *
     * @param player2 El jugador 2.
     */
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    /**
     * Establece el board del juego.
     *
     * @param board El board del juego.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Establece la cantidad de turnos que llevan.
     *
     * @param currentTurn La cantidad de turnos que llevan.
     */
    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }

    /**
     * Establece el historial de movimientos del juego.
     *
     * @param moveHistory La lista de movimientos realizada en el juego.
     */
    public void setMoveHistory(List<String> moveHistory) {
        this.moveHistory = moveHistory;
    }

    //---------------------------------------------------------//

    /**
     * RF12.
     * Constructor del juego/partida.
     * @param player1 Primer jugador de la partida.
     * @param player2 Segundo jugador de la partida.
     * @param board Tablero de la partida.
     * @param currentTurn Los turnos que lleva la partida.
     */
    public Game(Player player1, Player player2, Board board, int currentTurn) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.currentTurn = currentTurn;
        this.moveHistory = new ArrayList<>();
    }

    /**
     * RF13.
     * Registra un movimiento en el historial.
     * @param columna La columna donde se colocó la ficha.
     * @param color El color de la ficha jugada.
     */
    public void history(int columna, String color) {
        String movimiento = "(" + color + ", " + columna + ")/n";
        moveHistory.add(movimiento);
    }
    

}
