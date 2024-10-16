package org.example;

import java.util.Scanner;

/**
 * Console-based implementation of the Connect4View interface.
 */
public class ConsoleView implements Connect4View {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Displays the game board in the console.
     *
     * @param board a 2D array representing the current game state.
     */
    @Override
    public void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char display = ' ';
                if (board[i][j] == 1) {
                    display = 'R'; // Red
                } else if (board[i][j] == 2) {
                    display = 'Y'; // Yellow
                }
                System.out.print("|" + display);
            }
              System.out.println("|");
        }
        // Print column numbers from 1 to 7
        for (int i = 1; i <= board[0].length; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();
    }

    /**
     * Prints a message to the user in the console.
     *
     * @param message the message to be displayed.
     */
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Reads the user's input from the console to select a column.
     *
     * @return the column number chosen by the user.
     */
    @Override
    public int getUserInput() {
        return scanner.nextInt();
    }
}
