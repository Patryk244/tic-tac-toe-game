package org.example.tictactoegame;

import javafx.scene.control.Button;

public class DetermineWinner {

    public static boolean checkWinner(String player, int boardSize, Button[][] board) {
        if (checkingWinnerForRow(player, boardSize, board)) {
            return true;
        } else if (checkingWinnerForColumn(player, boardSize, board)) {
            return true;
        } else if (checkingWinnerForAcross(player, boardSize, board)) {
            return true;
        }
        return false;
    }
    private static boolean checkingWinnerForRow(String player, int boardSize, Button[][] board) {
        for (int row = 0; row < boardSize; row++) {
            boolean win = true;
            for (int col = 0; col < boardSize; col++) {
                if (!board[row][col].getText().equals(player)) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        return false;
    }
    private static boolean checkingWinnerForColumn(String player, int boardSize, Button[][] board) {
        for (int col = 0; col < boardSize; col++) {
            boolean win = true;
            for (int row = 0; row < boardSize; row++) {
                if (!board[row][col].getText().equals(player)) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        return false;
    }

    private static boolean checkingWinnerForAcross(String player, int boardSize, Button[][] board) {
        boolean winMain = true;
        for (int i = 0; i < boardSize; i++) {
            if (!board[i][i].getText().equals(player)) {
                winMain = false;
                break;
            }
        }

        boolean winAnti = true;
        for (int i = 0; i < boardSize; i++) {
            if (!board[i][boardSize - 1 - i].getText().equals(player)) {
                winAnti = false;
                break;
            }
        }
        return winMain || winAnti;
    }
}