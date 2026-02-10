package lightsout;

import java.util.Scanner;

/**
 * Console-based UI for testing the Lights Out game logic.
 * Demonstrates decoupled design - logic works independently of UI.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter board size (3, 5, or 7): ");
        int size = scanner.nextInt();
        
        GameController game = new GameController(size);
        game.randomize(size * size / 2);

        while (!game.isWon()) {
            printBoard(game.getState());
            System.out.printf("Moves: %d | Enter row col (0-%d): ", game.getMoveCount(), size - 1);
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            
            if (r >= 0 && r < size && c >= 0 && c < size) {
                game.makeMove(r, c);
            } else {
                System.out.println("Invalid input!");
            }
        }

        printBoard(game.getState());
        System.out.printf("You won in %d moves!%n", game.getMoveCount());
        scanner.close();
    }

    private static void printBoard(GameState state) {
        System.out.println();
        for (int r = 0; r < state.getSize(); r++) {
            for (int c = 0; c < state.getSize(); c++) {
                System.out.print(state.isLit(r, c) ? "█ " : "░ ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

