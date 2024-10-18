package version1;

import java.util.Random;

/**
 * Presenter class for the Connect 4 game, handling communication between the model and the view.
 */
public class Connect4Presenter {
    private Connect4Model model;
    private Connect4View view;
    private boolean isComputerPlayer;

    /**
     * Initializes the presenter with a model and a view.
     *
     * @param model the Connect 4 model.
     * @param view the view that interacts with the user.
     */
    public Connect4Presenter(Connect4Model model, Connect4View view, boolean isComputerPlayer) {
        this.model = model;
        this.view = view;
        this.isComputerPlayer = isComputerPlayer;
    }

    /**
     * Starts the Connect 4 game loop, handling user inputs and checking for a winner.
     */
    public void startGameHuman() {
        boolean gameWon = false;

        while (!gameWon) {
            view.printBoard(model.getBoard());
            view.printMessage("Player " + model.getCurrentPlayer() + " (Red=1, Yellow=2), choose a column (1-7): ");
            int col = view.getUserInput() - 1; // adjust input to be zero based

            if (col >= 0 && col < 7 && model.dropDisc(col)) {
                if (model.checkForWin()) {
                    view.printBoard(model.getBoard());
                    view.printMessage("Player " + model.getCurrentPlayer() + " wins!");
                    gameWon = true;
                } else {
                    model.switchPlayer();
                }
            } else {
                view.printMessage("Column full or invalid. Try again.");
            }
        }
    }

    /**
     * Runs the Connect 4 game in Human vs Computer mode.
     */
    public void startGameComputer() {
        boolean gameWon = false;
        Random random = new Random();

        while (!gameWon) {
            view.printBoard(model.getBoard());
            int col;

            // Human player (Player 1)
            if (model.getCurrentPlayer() == 1) {
                view.printMessage("Player " + model.getCurrentPlayer() + " (Red=1, Yellow=2), choose a column (1-7): ");
                col = view.getUserInput() - 1; // adjust input to be zero based
            } else {
                // Computer player (Player 2)
                    col = random.nextInt(7);
            }
            if (model.dropDisc(col)) {
                if (model.checkForWin()) {
                    view.printBoard(model.getBoard());
                    view.printMessage("Player " + model.getCurrentPlayer() + " wins!");
                    gameWon = true;
                } else {
                    model.switchPlayer();
                }
            } else if (model.getCurrentPlayer() == 1) { // Only give invalid message for human player
                view.printMessage("Column full or invalid. Try again.");
            }
        }
    }
}


