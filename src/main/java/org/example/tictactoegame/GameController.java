package org.example.tictactoegame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GameController {
    @FXML
    private GridPane gameBoard;
    @FXML
    private Label scoreO;
    @FXML
    private Label scoreX;

    private int boardSize = 3;
    private String currentPlayer = "X";
    private Button[][] board;
    private int pointX = 0;
    private int pointO = 0;

    public void setBoardSize(int size) {
        this.boardSize = size;
        generateBoard(boardSize);
    }

    private Button addButton() {
        Button cell = new Button();
        cell.getStyleClass().add("button");
        cell.setMinSize(60, 60);
        return cell;
    }

    private void generateBoard(int size) {
        gameBoard.getChildren().clear();
        board = new Button[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Button cell = addButton();
                int r = row, c = col;
                cell.setOnAction(e -> handleMove(cell));
                gameBoard.add(cell, col, row);
                board[row][col] = cell;
            }
        }
    }

    private void handleMove(Button cell) {
        if (!cell.getText().isEmpty()) {
            return;
        }
        cell.setText(currentPlayer);

        if (checkAndHandleWinner()) return;

        if (isBoardFull()) {
            System.out.println("Draw!");
            resetBoard();
        }

        currentPlayer = "O";
        ComputerPlayer.drawMove(board, boardSize, currentPlayer);

        if (checkAndHandleWinner()) return;

        if (isBoardFull()) {
            System.out.println("Draw");
            resetBoard();
        }

        currentPlayer = "X";
    }

    private boolean isBoardFull() {
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                if (board[row][col].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkAndHandleWinner() {
        if (DetermineWinner.checkWinner(currentPlayer, boardSize, board)) {
            System.out.println("Winner is " + currentPlayer);
            if (currentPlayer.equals("X")) {
                scoreX.setText(String.valueOf(++pointX));
            } else {
                scoreO.setText(String.valueOf(++pointO));
            }
            resetBoard();
            return true;
        }
        return false;
    }

    private void resetBoard() {
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                board[r][c].setText("");
            }
        }
    }
}