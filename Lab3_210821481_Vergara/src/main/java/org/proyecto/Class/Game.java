package org.proyecto.Class;
import java.util.ArrayList;
import java.util.List;

public class Game {
    // Atributos.
    private Player player1;
    private Player player2;
    private Board board;
    private int currentTurn;
    private List<String> historial;

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
    public List<String> getHistorial() {
        return historial;
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
     * @param historial La lista de movimientos realizada en el juego.
     */
    public void setHistorial(List<String> historial) {
        this.historial = historial;
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
        this.historial = new ArrayList<>();
    }

    /**
     * RF13.
     * Registra un movimiento en el historial.
     * @param columna La columna donde se colocó la ficha.
     * @param color El color de la ficha jugada.
     */
    public void history(int columna, String color) {
        String movimiento = "(" + color + ", " + columna + ")/n";
        historial.add(movimiento);
    }

    /**
     * RF14.
     * Verifica si el juego está en estado de empate
     * @return true si hay empate, false en caso contrario
     */
    public boolean esEmpate() {
        boolean noFichas = false;
        if (player1.getRemainingPieces() == 0 || player2.getRemainingPieces() == 0) {
            noFichas = true;
        }
        //
        if (noFichas && board.entregarGanador() == 0|| board.sePuedeJugar() && board.entregarGanador() == 0) {
            return true;
        }
        return false;
    }

    /**
     * RF15.
     * Actualiza las estadisticas de los jugadores; win, loss o draw.
     */
    public void actualizarEstadisticas() {
        if (board.entregarGanador() == 1) {
            player1.setWins(player1.getWins() + 1);
            player2.setLosses(player2.getLosses() + 1);
        }
        if (board.entregarGanador() == 2) {
            player2.setWins(player2.getWins() + 1);
            player1.setLosses(player1.getLosses() + 1);
        }
        if (esEmpate()) {
            player1.setDraws(player1.getDraws() + 1);
            player2.setDraws(player2.getDraws() + 1);
        }
    }

}
