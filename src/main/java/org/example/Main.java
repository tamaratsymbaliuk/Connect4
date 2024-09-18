package org.example;

public class Main {
    public static void main(String[] args) {
        Connect4Model model = new Connect4Model();
        Connect4View view = new ConsoleView();
        Connect4Presenter presenter = new Connect4Presenter(model, view);
        presenter.startGame();
        System.out.println("testgi");
    }
}

