package lightsout;

import java.util.Random;

/**
 * Controls game flow, move counting, and board initialization.
 * Delegates grid operations to GameState while managing game-level logic.
 */
public class GameController {
    private final GameState state;
    private int moveCount;

    /**
     * Constructs a controller with a new game state of given size.
     * Initializes move count to 0 (default).
     * @param size the board dimension
     */
    public GameController(int size) {
        this.state = new GameState(size);
        this.moveCount = 0;
    }

    /**
     * Processes a player move at the given position.
     * Modifies the game state via toggle and increments move count.
     * @param r the row index
     * @param c the column index
     */
    public void makeMove(int r, int c) {
        state.toggle(r, c);
        moveCount++;
    }

    /**
     * Resets the game to initial state.
     * Restores move count to 0 and clears all grid cells to default (OFF).
     */
    public void reset() {
        state.clear();
        moveCount = 0;
    }

    /**
     * Randomizes the board by simulating random moves.
     * Modifies the game state to create a solvable puzzle.
     * Restores move count to 0 after setup.
     * @param moves number of random toggles to perform
     */
    public void randomize(int moves) {
        reset();
        Random rand = new Random();
        int size = state.getSize();
        for (int i = 0; i < moves; i++) {
            state.toggle(rand.nextInt(size), rand.nextInt(size));
        }
        moveCount = 0;
    }

    /**
     * Checks if the player has won.
     * Accesses game state to determine if all lights are off.
     * @return true if game is won, false otherwise
     */
    public boolean isWon() {
        return state.isGameOver();
    }

    /**
     * Gets the current move count.
     * Accesses moveCount without modification.
     * @return number of moves made
     */
    public int getMoveCount() {
        return moveCount;
    }

    /**
     * Gets the underlying game state for UI rendering.
     * @return the GameState instance
     */
    public GameState getState() {
        return state;
    }
}

