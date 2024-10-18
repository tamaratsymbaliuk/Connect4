package version1;

/**
 * Model class for Connect 4 game, representing the game board and the game logic.
 */

public class Connect4Model {
    private static final int rows = 6;
    private static final int cols = 7;
    private static final int red = 1;
    private static final int yellow = 2;
    private static final int empty = 0;

    private int[][] board = new int[rows][cols];
    private int currentPlayer = red;

    /**
     * Initializes the Connect 4 board with empty cells and sets the first player to red.
     */
    public Connect4Model() {
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
     * Checks if the current player has won the game.
     *
     * @return true if the current player has a winning line, false otherwise.
     */
    public boolean checkForWin() {
        return checkLines() || checkDiagonals();
    }

    private boolean checkLines() {
        // Check horizontal and vertical
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols - 3; col++) { // excluding the last 3 columns as it wouldn’t allow enough space for a horizontal win
                if (board[row][col] == currentPlayer &&
                        board[row][col] == board[row][col + 1] &&
                        board[row][col] == board[row][col + 2] &&
                        board[row][col] == board[row][col + 3]) {
                    return true;
                }
            }
        }
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows - 3; row++) { // // excluding the last 3 rows as it wouldn’t allow enough space for a horizontal win
                if (board[row][col] == currentPlayer &&
                        board[row][col] == board[row + 1][col] &&
                        board[row][col] == board[row + 2][col] &&
                        board[row][col] == board[row + 3][col]) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkDiagonals() {
        // Check diagonals
        for (int row = 0; row < rows - 3; row++) {
            for (int col = 0; col < cols - 3; col++) {
                if (board[row][col] == currentPlayer &&
                        board[row][col] == board[row + 1][col + 1] &&
                        board[row][col] == board[row + 2][col + 2] &&
                        board[row][col] == board[row + 3][col + 3]) {
                    return true;
                }
            }
        }

        for (int row = 3; row < rows; row++) {
            for (int col = 0; col < cols - 3; col++) {
                if (board[row][col] == currentPlayer &&
                        board[row][col] == board[row - 1][col + 1] &&
                        board[row][col] == board[row - 2][col + 2] &&
                        board[row][col] == board[row - 3][col + 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Switches the turn to the other player.
     */
    public void switchPlayer() {
        currentPlayer = (currentPlayer == red) ? yellow : red;
    } // ternary operator

    /**
     * Gets the current state of the game board.
     *
     * @return a 2D array representing the game board.
     */
    public int[][] getBoard() {
        return board;
    }
}




