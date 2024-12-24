package org.proyecto;
import org.proyecto.Class.TDAgameClass_210821481_VergaraGodoy;
import org.proyecto.Class.TDAplayerClass_210821481_VergaraGodoy;
import org.proyecto.Class.TDAboardClass_210821481_VergaraGodoy;

import java.util.Scanner;

public class Main {
    public static TDAgameClass_210821481_VergaraGodoy TDAgameClass210821481VergaraGodoy;
    public static TDAboardClass_210821481_VergaraGodoy TDAboardClass210821481VergaraGodoy;
    public static TDAplayerClass_210821481_VergaraGodoy player1;
    public static TDAplayerClass_210821481_VergaraGodoy player2;
    public static Scanner scanner = new Scanner(System.in);

    /// ___________________________________________________________________________///

    public static void main(String[] args) {
        boolean estadoMenu = true;

        System.out.println("+------------------+");
        System.out.println("|   BIENVENIDO/A   |");
        System.out.println("|     AL JUEGO     |");
        System.out.println("|     CONNECT 4    |");
        System.out.println("+------------------+\n");
        System.out.println("+------------------+");
        System.out.println("|       MENU       |");
        System.out.println("|------------------|");
        System.out.println("|                  |");
        System.out.println("| 1 | JUGAR.       |");
        System.out.println("|                  |");
        System.out.println("| 2 | SALIR.       |");
        System.out.println("|                  |");
        System.out.println("+------------------+");

        while (estadoMenu) {
            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:
                        inicializarComponentes(); // Llamar a la función que inicia el juego
                        break;
                    case 2:
                        System.out.println("+--------------------+");
                        System.out.println("| Gracias por jugar! |");
                        System.out.println("+--------------------+");
                        System.exit(0); // Termina el programa.
                        estadoMenu = false;
                        break;
                    default:
                        System.out.println("Opcion invalida. Entre 1 y 2.");
                        break;
                }
            }
            else {
                System.out.println("Entrada no valida. Por favor, ingrese un numero.");
                scanner.nextLine();
            }
        }
    }

    ///___________________________________________________________________________///

    public static void inicializarComponentes() {
        // Inicializar el número de fichas.
        int fichasGame = 0;

        // Validar las fichas.
        do {
            System.out.println("Ingrese el numero de fichas que quiere jugar, entre 4 y 21: ");
            if (scanner.hasNextInt()) {
                fichasGame = scanner.nextInt();
                scanner.nextLine(); // Agregar esta línea
                if (fichasGame < 4 || fichasGame > 21) {
                    System.out.println("Las fichas deben ser solo entre 4 y 21.");
                }
            }
            else {
                System.out.println("Por favor ingrese un numero valido.");
                scanner.next();
            }
        } while (fichasGame < 4 || fichasGame > 21);

        // Inicializar el jugador 1.
        String nombreP1 = "";
        String colorP1 = "";

        // Validar nombre del jugador 1.
        do {
            System.out.println("Ingrese el nombre del jugador 1: ");
            if (scanner.hasNextLine()) {
                nombreP1 = scanner.nextLine().trim(); // trim() elimina espacios en blanco
                if (nombreP1.isEmpty() || !nombreP1.matches("[a-zA-Z ]+")) {
                    System.out.println("El nombre debe contener solo letras y espacios.");
                    nombreP1 = "";
                }
            }
        } while (nombreP1.isEmpty());

        // Validar color del jugador 1.
        do {
            System.out.println("Ingrese el color de la ficha para el jugador 1: ");
            if (scanner.hasNextLine()) {
                colorP1 = scanner.nextLine().trim(); // trim() elimina espacios en blanco.
                if (colorP1.isEmpty() || !colorP1.matches("[a-zA-Z]+")) {
                    System.out.println("El color debe contener solo letras.");
                    colorP1 = "";
                }
            }
        } while (colorP1.isEmpty());

        // Crear jugador 1.
        player1 = new TDAplayerClass_210821481_VergaraGodoy(1, nombreP1, colorP1, 0, 0, 0, fichasGame);

        // Inicializar el jugador 2.
        String nombreP2 = "";
        String colorP2 = "";

        // Validar nombre del jugador 2.
        do {
            System.out.println("Ingrese el nombre del jugador 2: ");
            if (scanner.hasNextLine()) {
                nombreP2 = scanner.nextLine().trim();
                if (nombreP2.isEmpty() || !nombreP2.matches("[a-zA-Z ]+")) {
                    System.out.println("El nombre debe contener solo letras y espacios.");
                    nombreP2 = "";
                }
            }
        } while (nombreP2.isEmpty());

        // Validar color del jugador 2.
        do {
            System.out.println("Ingrese el color de la ficha para el jugador 2: ");
            if (scanner.hasNextLine()) {
                colorP2 = scanner.nextLine().trim();
                if (colorP2.isEmpty() || !colorP2.matches("[a-zA-Z]+")) {
                    System.out.println("El color debe contener solo letras.");
                    colorP2 = "";
                }
            }
        } while (colorP2.isEmpty());

        // Crear jugador 2.
        player2 = new TDAplayerClass_210821481_VergaraGodoy(2, nombreP2, colorP2, 0, 0, 0, fichasGame);

        System.out.println("Se iniciara el juego con...");
        System.out.println("Jugador 1: " + player1.getName() + " usando el color " + player1.getColor() + " con " + fichasGame + " fichas.");
        System.out.println("Jugador 2: " + player2.getName() + " usando el color " + player2.getColor() + " con " + fichasGame + " fichas.");
        System.out.println("\nComienza jugando el jugador 1.");

        juego(player1, player2, fichasGame);

    }

    public static void juego(TDAplayerClass_210821481_VergaraGodoy player1, TDAplayerClass_210821481_VergaraGodoy player2, int fichasGame) {
        boolean seguirJugando = true;
        while (seguirJugando) {
            TDAboardClass210821481VergaraGodoy = new TDAboardClass_210821481_VergaraGodoy();
            player1.setRemainingPieces(fichasGame);  // Reiniciar fichas jugador 1
            player2.setRemainingPieces(fichasGame);
            TDAboardClass210821481VergaraGodoy.setPlayers(player1, player2);
            TDAgameClass210821481VergaraGodoy = new TDAgameClass_210821481_VergaraGodoy(player1, player2, TDAboardClass210821481VergaraGodoy, 0);
            boolean juegoTerminado = false;

            while (!juegoTerminado) {
                if (player1.getRemainingPieces() <= 0 && player2.getRemainingPieces() <= 0) {
                    System.out.println("¡No quedan fichas disponibles! El juego ha terminado.");
                    juegoTerminado = true;
                    break;
                }
                if (TDAgameClass210821481VergaraGodoy.getCurrentPlayer() == 1) {
                    System.out.println("\n------- Turno jugador 1 -------");
                    int columna = 0;
                    boolean entradaValida = false;

                    while (!entradaValida) {
                        System.out.println("Seleccione la columna (1-7):\n");
                        if (scanner.hasNextInt()) {
                            columna = scanner.nextInt();
                            if (columna >= 1 && columna <= 7) {
                                if (TDAgameClass210821481VergaraGodoy.realizarMovimiento(player1, columna - 1)) {
                                    entradaValida = true;
                                    // Verificar si el juego terminó después del movimiento
                                    if (TDAgameClass210821481VergaraGodoy.endGame()) {
                                        juegoTerminado = true;
                                        break;
                                    }
                                }
                            }
                            else {
                                System.out.println("Por favor, ingrese un numero entre 1 y 7.");
                            }
                        }
                        else {
                            System.out.println("Por favor, ingrese un numero valido.");
                            scanner.next();
                        }
                    }
                }
                else {
                    System.out.println("\n------- Turno jugador 2 -------");
                    int columna = 0;
                    boolean entradaValida = false;

                    while (!entradaValida) {
                        System.out.println("Seleccione la columna (1-7):\n");
                        if (scanner.hasNextInt()) {
                            columna = scanner.nextInt();
                            if (columna >= 1 && columna <= 7) {
                                if (TDAgameClass210821481VergaraGodoy.realizarMovimiento(player2, columna - 1)) {
                                    entradaValida = true;
                                    if (TDAgameClass210821481VergaraGodoy.endGame()) {
                                        juegoTerminado = true;
                                        break;
                                    }
                                }
                            }
                            else {
                                System.out.println("Por favor, ingrese un numero entre 1 y 7.");
                            }
                        }
                        else {
                            System.out.println("Por favor, ingrese un numero valido.");
                            scanner.next();
                        }
                    }
                }
            }

            // Mostrar estadísticas
            System.out.println("\n+-----------------------+");
            System.out.println("| Estadisticas Actuales |");
            System.out.println("+-----------------------+");
            System.out.println(player1.getName() + " - Victorias: " + player1.getWins() + " Derrotas: " + player1.getLosses() + " Empates: " + player1.getDraws());
            System.out.println(player2.getName() + " - Victorias: " + player2.getWins() + " Derrotas: " + player2.getLosses() + " Empates: " + player2.getDraws());


            // Preguntar si quieren jugar de nuevo
            System.out.println("\n+--------------------------+");
            System.out.println("|    DESEA OTRA PARTIDA?   |");
            System.out.println("|--------------------------|");
            System.out.println("|                          |");
            System.out.println("| 1 | SI.                  |");
            System.out.println("|                          |");
            System.out.println("| 2 | NO.(SALIR DEL JUEGO) |");
            System.out.println("|                          |");
            System.out.println("+--------------------------+");

            boolean entradaValida = false;
            while (!entradaValida) {
                if (scanner.hasNextInt()) {
                    int opcion = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcion) {
                        case 1:
                            System.out.println("\n+--------------------+");
                            System.out.println("|   Nueva partida!   |");
                            System.out.println("+--------------------+\n");
                            entradaValida = true;
                            break;
                        case 2:
                            seguirJugando = false;
                            entradaValida = true;
                            System.out.println("+--------------------+");
                            System.out.println("| Gracias por jugar! |");
                            System.out.println("+--------------------+\n");
                            System.out.println("+----------------------+");
                            System.out.println("| Estadisticas Finales |");
                            System.out.println("+----------------------+");
                            System.out.println(player1.getName() + " - Victorias: " + player1.getWins() + " Derrotas: " + player1.getLosses() + " Empates: " + player1.getDraws());
                            System.out.println(player2.getName() + " - Victorias: " + player2.getWins() + " Derrotas: " + player2.getLosses() + " Empates: " + player2.getDraws());
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Opción invalida. Por favor ingrese 1 o 2.");
                            break;
                    }
                }
                else {
                    System.out.println("Por favor ingrese un número valido (1 o 2).");
                    scanner.nextLine();
                }
            }
        }
    }
}
