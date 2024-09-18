package org.example;

public class Connect4Model {
    private static final int rows = 6;
    private static final int cols = 7;
    private static final int red = 1;
    private static final int yellow = 2;
    private static final int empty = 0;

    private int[][] board = new int[rows][cols];
    private int currentPlayer = red;

    public Connect4Model() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = empty;
            }
        }
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean dropDisc(int col) {
        if (col < 0 || col >= cols || board[0][col] != empty) {
            return false;
        }
        for (int row = rows - 1; row >= 0; row--) {
            if (board[row][col] == empty) {
                board[row][col] = currentPlayer;
                return true;
            }
        }
        return false;
    }

    public boolean checkForWin() {
        return checkLines() || checkDiagonals();
    }

    private boolean checkLines() {
        // Check horizontal and vertical
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols - 3; col++) {
                if (board[row][col] == currentPlayer &&
                        board[row][col] == board[row][col + 1] &&
                        board[row][col] == board[row][col + 2] &&
                        board[row][col] == board[row][col + 3]) {
                    return true;
                }
            }
        }
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows - 3; row++) {
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

    public void switchPlayer() {
        currentPlayer = (currentPlayer == red) ? yellow : red;
    }

    public int[][] getBoard() {
        return board;
    }
}




