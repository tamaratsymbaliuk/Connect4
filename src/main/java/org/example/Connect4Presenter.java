package org.example;

/**
 * Presenter class for the Connect 4 game, handling communication between the model and the view.
 */
public class Connect4Presenter {
    private Connect4Model model;
    private Connect4View view;

    /**
     * Initializes the presenter with a model and a view.
     *
     * @param model the Connect 4 model.
     * @param view the view that interacts with the user.
     */
    public Connect4Presenter(Connect4Model model, Connect4View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Starts the Connect 4 game loop, handling user inputs and checking for a winner.
     */
    public void startGame() {
        boolean gameWon = false;

        while (!gameWon) {
            view.printBoard(model.getBoard());
            view.printMessage("Player " + model.getCurrentPlayer() + " (Red=1, Yellow=2), choose a column (0-6): ");
            int col = view.getUserInput();

            if (model.dropDisc(col)) {
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
}


