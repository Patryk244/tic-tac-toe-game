package org.example.tictactoegame;

import javafx.scene.control.Button;

import java.util.Random;

public class ComputerPlayer {
    static Random rand = new Random();

    public static void drawMove(Button[][] board, int boardSize, String currentPlayer) {
        int r, c;
        do {
            r = rand.nextInt(boardSize);
            c = rand.nextInt(boardSize);
        } while (!board[r][c].getText().isEmpty());

        board[r][c].setText(currentPlayer);
    }
}