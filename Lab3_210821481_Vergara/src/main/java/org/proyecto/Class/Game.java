package org.proyecto.Class;
import org.proyecto.Interface.TDAgame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game implements TDAgame {
    // Atributos.
    private Player player1;
    private Player player2;
    private Board board;
    private int currentTurn;
    private Piece piece;
    private List<String> historial;

    //---------------------------------------------------------//

    // Getter.
    /**
     * Obtiene el jugador 1.
     * @return El jugador 1.
     */
    @Override
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Obtiene el jugador 2.
     * @return El jugador 2.
     */
    @Override
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Obtiene el board del juego.
     * @return El board del juego.
     */
    @Override
    public Board getBoard() {
        return board;
    }

    /**
     * Obtiene la cantidad de turnos que llevan.
     * @return La cantidad de turnos que llevan.
     */
    @Override
    public int getCurrentTurn() {
        return currentTurn;
    }

    /**
     * Obtiene el historial de movimientos del juego.
     * @return La lista de movimientos realizada en el juego.
     */
    @Override
    public List<String> getHistorial() {
        return historial;
    }

    // Setter.
    /**
     * Establece el jugador 1.
     * @param player1 El jugador 1.
     */
    @Override
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    /**
     * Establece el jugador 2.
     * @param player2 El jugador 2.
     */
    @Override
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    /**
     * Establece el board del juego.
     * @param board El board del juego.
     */
    @Override
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Establece la cantidad de turnos que llevan.
     * @param currentTurn La cantidad de turnos que llevan.
     */
    @Override
    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }

    /**
     * Establece el historial de movimientos del juego.
     * @param historial La lista de movimientos realizada en el juego.
     */
    @Override
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
    @Override
    public void history(int columna, String color) {
        String movimiento = "(" + color + ", " + columna + ")/n";
        historial.add(movimiento);
    }

    /**
     * RF14.
     * Verifica si el juego está en estado de empate
     * @return true si hay empate, false en caso contrario
     */
    @Override
    public boolean esEmpate() {
        if (player1.getRemainingPieces() == 0 && player2.getRemainingPieces() == 0 && board.entregarGanador() == 0 || !board.sePuedeJugar() && board.entregarGanador() == 0) {
            return true;
        }
        return false;
    }

    /**
     * RF15.
     * Actualiza las estadisticas de los jugadores; win, loss o draw.
     */
    @Override
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

    /**
     * RF16.
     * Verifica a qué jugador le toca jugar.
     */
    @Override
    public int getCurrentPlayer() {
        int currentTurn = getCurrentTurn();
        if (currentTurn % 2 == 0) {  // Turno par.
            return 1;
        }
        else { // Turno impar.
            return 2;
        }
    }

    /**
     * RF17.
     * Entrega el estado actual del tablero en juego.
     */
    @Override
    public void boardGetState() {
        int[][] tablero = board.getBoard();
        System.out.print("Tablero actual:");
        System.out.println();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * RF18.
     * Si el juego termina, actualiza las estadisticas.
     */
    @Override
    public boolean endGame() {
        if (board.entregarGanador() != 0 || esEmpate()) {
            actualizarEstadisticas();
            return true;
        }
        return false;
    }

    /**
     * RF19.
     * Permite a un jugador realizar un movimiento.
     */
    @Override
    public void realizarMovimiento(Player player, int columna) {
        if (endGame()) {
            System.out.println("El juego ha terminado");
            return;
        }
        if (getCurrentPlayer() != player.getID()) {
            System.out.println("No es tu turno");
            return;
        }
        String colorPieza = player.getColor();
        Piece piece = new Piece(colorPieza);
        if (getCurrentPlayer() == player.getID()) {
            board.jugarFicha(columna, piece);
            setCurrentTurn(currentTurn + 1);
            player.setRemainingPieces(player.getRemainingPieces() - 1);
            history(columna, colorPieza);
        }
    }
}
