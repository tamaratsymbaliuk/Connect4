package org.example;

import java.util.Scanner;

public class ConsoleView implements Connect4View {
    private Scanner scanner = new Scanner(System.in);
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
        for (int i = 0; i < board[0].length; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public int getUserInput() {
        return scanner.nextInt();
    }
}
