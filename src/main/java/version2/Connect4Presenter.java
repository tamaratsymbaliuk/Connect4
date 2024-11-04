package version2;

import java.util.Random;

/**
 * Presenter class for the Connect 4 game, handling communication between the model and the view.
 */
public class Connect4Presenter {
    private final Connect4Model model;
    private final Connect4View view;
    private final boolean isComputerPlayer;

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
    public void startGame() {
        view.printBoard(model.getBoard());
        while (true) {
            int col = view.getUserInput();
            if (model.dropDisc(col)) {
                int lastRow = findRowForDisc(col);
                view.printBoard(model.getBoard());

                if (model.checkForWin(lastRow, col)) {
                    view.printMessage("Player " + (model.getCurrentPlayer() == 1 ? "Red" : "Yellow") + " wins!");
                    break;
                }

                model.switchPlayer();
            } else {
                view.printMessage("Invalid move! Try again.");
            }
        }
    }

    public void startGameComputer() {
        view.printBoard(model.getBoard());
        while (true) {
            if (model.getCurrentPlayer() == Connect4Model.red) {
                int col = view.getUserInput();
                if (model.dropDisc(col)) {
                    int lastRow = findRowForDisc(col);
                    view.printBoard(model.getBoard());

                    if (model.checkForWin(lastRow, col)) {
                        view.printMessage("Player Red wins!");
                        break;
                    }

                    model.switchPlayer();
                } else {
                    view.printMessage("Invalid move! Try again.");
                }
            } else {
                int col = computerMove();
                model.dropDisc(col);
                int lastRow = findRowForDisc(col);
                view.printBoard(model.getBoard());

                if (model.checkForWin(lastRow, col)) {
                    view.printMessage("Player Yellow wins!");
                    break;
                }

                model.switchPlayer();
            }
        }
    }

    private int findRowForDisc(int col) {
        for (int row = 0; row < model.getBoard().length; row++) {
            if (model.getBoard()[row][col] != 0) {
                return row;
            }
        }
        return -1; // This should never happen if the move was valid
    }

    private int computerMove() {
        int col;
        do {
            col = (int) (Math.random() * model.getBoard()[0].length);
        } while (!isValidMove(col));
        return col;
    }

    private boolean isValidMove(int col) {
        return model.getBoard()[0][col] == 0; // Top row must be empty for a valid move
    }
}