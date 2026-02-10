package lightsout;

/**
 * Represents the state of the Lights Out game board.
 * Manages a 2D boolean grid where true = light ON, false = light OFF.
 */
public class GameState {
    private final boolean[][] grid;
    private final int size;

    /**
     * Constructs a new game state with the specified board size.
     * @param size the dimension of the square grid (size x size)
     */
    public GameState(int size) {
        this.size = size;
        this.grid = new boolean[size][size];
    }

    /**
     * Toggles a cell and its four orthogonal neighbors (up, down, left, right).
     * Accesses and modifies the grid at position (r, c) and adjacent positions.
     * @param r the row index of the cell to toggle
     * @param c the column index of the cell to toggle
     */
    public void toggle(int r, int c) {
        flip(r, c);
        flip(r - 1, c);
        flip(r + 1, c);
        flip(r, c - 1);
        flip(r, c + 1);
    }

    /**
     * Flips a single cell if within bounds.
     * Modifies grid[r][c] by inverting its boolean value.
     * @param r the row index
     * @param c the column index
     */
    private void flip(int r, int c) {
        if (r >= 0 && r < size && c >= 0 && c < size) {
            grid[r][c] = !grid[r][c];
        }
    }

    /**
     * Checks if the game is over (all lights are off).
     * Accesses all cells in the grid to verify they are false.
     * @return true if all lights are off, false otherwise
     */
    public boolean isGameOver() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (grid[r][c]) return false;
            }
        }
        return true;
    }

    /**
     * Gets the state of a specific cell.
     * Accesses grid[r][c] without modification.
     * @param r the row index
     * @param c the column index
     * @return true if light is ON, false if OFF
     */
    public boolean isLit(int r, int c) {
        return grid[r][c];
    }

    /**
     * Sets a cell to a specific state directly.
     * Modifies grid[r][c] to the given value.
     * @param r the row index
     * @param c the column index
     * @param lit the new state (true = ON, false = OFF)
     */
    public void setCell(int r, int c, boolean lit) {
        grid[r][c] = lit;
    }

    /**
     * Resets all cells to OFF state.
     * Modifies entire grid, restoring all values to false (default).
     */
    public void clear() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                grid[r][c] = false;
            }
        }
    }

    /**
     * Gets the board size.
     * @return the dimension of the grid
     */
    public int getSize() {
        return size;
    }
}

