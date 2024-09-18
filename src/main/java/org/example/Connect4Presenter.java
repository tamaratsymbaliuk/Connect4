package org.example;

public class Connect4Presenter {
    private Connect4Model model;
    private Connect4View view;

    public Connect4Presenter(Connect4Model model, Connect4View view) {
        this.model = model;
        this.view = view;
    }
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


