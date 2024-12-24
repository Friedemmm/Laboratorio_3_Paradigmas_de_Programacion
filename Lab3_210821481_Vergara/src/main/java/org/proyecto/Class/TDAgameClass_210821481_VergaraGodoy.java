package org.proyecto.Class;
import org.proyecto.Interface.TDAgameInterface_210821481_VergaraGodoy;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una partida del juego Conecta 4.
 * Implementa la interfaz TDAgameInterface_210821481_VergaraGodoy.
 * Maneja la lógica del juego, los turnos y el estado de la partida.
 *
 * @author Sofia Vergara Godoy.
 * @version 1.0
 */
public class TDAgameClass_210821481_VergaraGodoy implements TDAgameInterface_210821481_VergaraGodoy {

    /// Atributos.

    /** Primer jugador de la partida */
    private TDAplayerClass_210821481_VergaraGodoy player1;
    /** Segundo jugador de la partida */
    private TDAplayerClass_210821481_VergaraGodoy player2;
    /** Tablero de la partida */
    private TDAboardClass_210821481_VergaraGodoy board;
    /** Turno actual */
    private int currentTurn;
    /** Pieza actual en juego */
    private TDApieceClass_210821481_VergaraGodoy piece;
    /** Historial de movimientos */
    private List<String> historial;

    //---------------------------------------------------------//

    /// Getter.

    /**
     * Obtiene el número del turno actual.
     * @return El número del turno actual.
     */
    @Override
    public int getCurrentTurn() {
        return currentTurn;
    }

    //---------------------------------------------------------//

    /// Setter.

    /**
     * Establece el número del turno actual.
     * @param currentTurn El nuevo número de turno.
     */
    @Override
    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }

    //---------------------------------------------------------//

    /**
     * RF12. Constructor de la clase que inicializa una nueva partida.
     * @param player1 Primer jugador.
     * @param player2 Segundo jugador.
     * @param board Tablero del juego.
     * @param currentTurn Turno inicial.
     */
    public TDAgameClass_210821481_VergaraGodoy(TDAplayerClass_210821481_VergaraGodoy player1, TDAplayerClass_210821481_VergaraGodoy player2, TDAboardClass_210821481_VergaraGodoy board, int currentTurn) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.currentTurn = currentTurn;
        this.historial = new ArrayList<>();
    }

    /**
     * RF13. Registra un movimiento en el historial de la partida.
     * @param columna Número de columna donde se realizó el movimiento.
     * @param color Color de la ficha jugada.
     */
    @Override
    public void history(int columna, String color) {
        String movimiento = "(" + color + ", " + (columna + 1) + ")";
        historial.add(movimiento);
        System.out.println("\nHistorial de movimientos:");
        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". " + historial.get(i));
        }
        System.out.println();
    }

    /**
     * RF14. Verifica si la partida ha terminado en empate.
     * @return true si hay empate, false en caso contrario.
     */
    @Override
    public boolean esEmpate() {
        if (player1.getRemainingPieces() == 0 && player2.getRemainingPieces() == 0 && board.entregarGanador() == 0 || !board.sePuedeJugar() && board.entregarGanador() == 0) {
            return true;
        }
        return false;
    }

    /**
     * RF15. Actualiza las estadísticas de los jugadores al finalizar la partida.
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
     * RF16. Determina qué jugador debe jugar en el turno actual.
     * @return 1 si es el turno del jugador 1, 2 si es el turno del jugador 2.
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
     * RF17. Muestra el estado actual del tablero en la consola.
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
     * RF18. Verifica si el juego ha terminado y actualiza las estadísticas si es necesario.
     * @return true si el juego ha terminado, false en caso contrario.
     */
    @Override
    public boolean endGame() {
        int ganador = board.entregarGanador();
        String tipoVictoria = "";

        // Determinar tipo de victoria
        if (ganador != 0) {
            if (board.verificarVictoriaVertical() != 0) {
                tipoVictoria = "vertical";
            }
            else if (board.verificarVictoriaHorizontal() != 0) {
                tipoVictoria = "horizontal";
            }
            else if (board.verificarVictoriaDiagonal() != 0) {
                tipoVictoria = "diagonal";
            }
        }

        if (ganador != 0 || esEmpate()) {
            actualizarEstadisticas();
            if (ganador == 1) {
                System.out.println("\n" + player1.getName() + " ha ganado con el color " +
                        player1.getColor() + " por victoria " + tipoVictoria + "!");
            }
            else if (ganador == 2) {
                System.out.println("\n" + player2.getName() + " ha ganado con el color " +
                        player2.getColor() + " por victoria " + tipoVictoria + "!");
            }
            else if (esEmpate()) {
                System.out.println("\nEl juego ha terminado en empate!");
            }
            return true;
        }
        return false;
    }

    /**
     * RF19. Permite a un jugador realizar un movimiento en el juego.
     * Verifica si el jugador tiene fichas disponibles y si el movimiento es válido.
     *
     * @param player El jugador que realiza el movimiento
     * @param columna La columna donde se intenta colocar la ficha (0-6)
     * @return true si el movimiento se realizó exitosamente, false en caso contrario
     */
    @Override
    public boolean realizarMovimiento(TDAplayerClass_210821481_VergaraGodoy player, int columna) {
        // Verificar si quedan fichas
        if (player.getRemainingPieces() <= 0) {
            System.out.println("No tienes más fichas disponibles!");
            return false;
        }

        String colorPieza = player.getColor();
        piece = new TDApieceClass_210821481_VergaraGodoy(colorPieza);
        if (board.jugarFicha(columna, piece)) {
            System.out.println("+--- JUGADA DE " + player.getName() + " ; RONDA NUMERO " + currentTurn + " ----+\n");
            setCurrentTurn(currentTurn + 1);
            player.setRemainingPieces(player.getRemainingPieces() - 1);
            System.out.println("Le quedan " + player.getRemainingPieces() + " fichas a " + player.getName());
            history(columna, colorPieza);
            boardGetState();
            return true;
        }
        return false;
    }
}
