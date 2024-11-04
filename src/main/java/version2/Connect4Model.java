package version2;

/**
 * Model class for Connect 4 game, with customizable board size and win condition.
 */

public class Connect4Model {
    private final int rows;
    private final int cols;
    private final int winSequence;
    public static final int red = 1;
    public static final int yellow = 2;
    private static final int empty = 0;

    private int[][] board;
    private int currentPlayer;

    /**
     * Initializes the Connect 4 board with customizable dimensions and win condition.
     *
     * @param rows        Number of rows for the board.
     * @param cols        Number of columns for the board.
     * @param winSequence Number of consecutive discs required to win.
     */
    public Connect4Model(int rows, int cols, int winSequence) {
        this.rows = rows;
        this.cols = cols;
        this.winSequence = winSequence;
        this.board = new int[rows][cols];
        this.currentPlayer = red;

        // Initialize the board with empty cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = empty;
            }
        }
    }

    /**
     * Gets the current player.
     *
     * @return the current player (1 for red, 2 for yellow).
     */
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Drops a disc for the current player in the specified column.
     *
     * @param col the column number where the disc should be dropped.
     * @return true if the disc is successfully dropped, false if the column is full or invalid.
     */
    public boolean dropDisc(int col) {
        if (col < 0 || col >= cols || board[0][col] != empty) { // checking if the top row is occupied
            return false;
        }
        for (int row = rows - 1; row >= 0; row--) { // starting at the bottom
            if (board[row][col] == empty) {
                board[row][col] = currentPlayer;
                return true;
            }
        }
        return false;
    }
    /**
     * Checks if the current player has won the game by placing their last disc in the winning sequence.
     *
     * @param lastRow the row index of the last placed disc.
     * @param lastCol the column index of the last placed disc.
     * ex:
     * dRow = 0: This means you stay on the same row (you're not moving up or down).
     * dCol = 1: This means you move right by one column at a time/ -1 to the left
     * @return true if the current player has a winning line, false otherwise.
     */
    public boolean checkForWin(int lastRow, int lastCol) {
        return checkDirection(lastRow, lastCol, 1, 0) ||  // Vertical
                checkDirection(lastRow, lastCol, 0, 1) ||  // Horizontal
                checkDirection(lastRow, lastCol, 1, 1) ||  // Diagonal (\)
                checkDirection(lastRow, lastCol, 1, -1);   // Diagonal (/)
    }

    /**
     * Checks if there are enough consecutive discs in the specified direction to win.
     *
     * @param row  The row of the last placed disc.
     * @param col  The column of the last placed disc.
     * @param dRow The row increment for the direction.
     * @param dCol The column increment for the direction.
     * @return true if the current player has a winning sequence in the given direction.
     */
    private boolean checkDirection(int row, int col, int dRow, int dCol) {
        int count = 1; // we start by counting the piece that was just placed

        // Check in the positive direction
        count += countConsecutive(row, col, dRow, dCol);

        // Check in the negative direction
        count += countConsecutive(row, col, -dRow, -dCol);

        return count >= winSequence;
    }

    /**
     * Counts consecutive discs of the current player in a specific direction.
     *
     * @param row  The starting row.
     * @param col  The starting column.
     * @param dRow The row increment.
     * @param dCol The column increment.
     * @return The count of consecutive discs.
     */
    private int countConsecutive(int row, int col, int dRow, int dCol) {
        int count = 0;

        for (int i = 1; i < winSequence; i++) { // we start from i = 1 to check the pieces that are adjacent to the last piece we just placed
            int newRow = row + i * dRow;
            int newCol = col + i * dCol;

            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || board[newRow][newCol] != currentPlayer) {
                break;
            }
            count++;
        }

        return count;
    }

    /**
     * Switches the turn to the other player.
     */
    public void switchPlayer() {
        currentPlayer = (currentPlayer == red) ? yellow : red;
    }

    /**
     * Gets the current state of the game board.
     *
     * @return a 2D array representing the game board.
     */
    public int[][] getBoard() {
        return board;
    }
}