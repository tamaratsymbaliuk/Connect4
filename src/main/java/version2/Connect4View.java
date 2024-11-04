package version2;

/**
 * Interface for the view in the Connect 4 game, defining how the user interacts with the game.
 */
public interface Connect4View {

    /**
     * Displays the current state of the game board.
     *
     * @param board a 2D array representing the game board.
     */
    void printBoard(int[][] board);

    /**
     * Prints a message to the user.
     *
     * @param message the message to be displayed.
     */
    void printMessage(String message);

    /**
     * Gets the user's input for selecting a column.
     *
     * @return the column number chosen by the user.
     */
    int getUserInput();
}

