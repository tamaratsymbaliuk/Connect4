package org.example;

/**
 * Main class for running the Connect 4 game.
 */
public class Main {

    /**
     * Main method to start the Connect 4 game.
     *
     * @param args command line arguments (not used).
     */
    public static void main(String[] args) {
        Connect4Model model = new Connect4Model();
        Connect4View view = new ConsoleView();
        Connect4Presenter presenter = new Connect4Presenter(model, view);
        presenter.startGame();
        System.out.println("testgi");
    }
}

