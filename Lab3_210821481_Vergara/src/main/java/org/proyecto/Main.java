package org.proyecto;
import org.proyecto.Class.Game;
import org.proyecto.Class.Player;
import org.proyecto.Class.Piece;
import org.proyecto.Class.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        Player player1 = new Player(1, "Jugador 1", "rojo", 0, 0, 0, 21);
        Player player2 = new Player(2, "Jugador 2", "amarillo", 0, 0, 0, 21);

        Piece piezaAmarilla = new Piece("amarillo");
        Piece piezaRoja = new Piece("rojo");

        Game game = new Game(player1, player2, board, 0);

        board.setPlayers(player1, player2);

        board.jugarFicha(3, piezaAmarilla);
        board.jugarFicha(3, piezaAmarilla);
        board.jugarFicha(3, piezaAmarilla);
        board.jugarFicha(3, piezaAmarilla);

        int ganador = board.entregarGanador();

        System.out.println(ganador);

        game.actualizarEstadisticas();

        System.out.println(player2.getWins());

        game.boardGetState();

    }
}