//Jack Gillis
//TicTacToe
//2/14/24
//Period 5

import java.util.Scanner;
import java.util.Arrays;

public class TicTacToe {
  private final int SIZE;
  private final char[][] board;
  private char currentPlayer;

  public TicTacToe(int size) {
    SIZE = size;
    board = new char[SIZE][SIZE];
    currentPlayer = 'X'; // Player X starts the game
    initializeBoard();
  }

  private void initializeBoard() {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        board[i][j] = '-';
      }
    }
  }

  public void printBoard() {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public boolean isBoardFull() {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        if (board[i][j] == '-') {
          return false;
        }
      }
    }
    return true;
  }

  public boolean makeMove(int row, int col) {
    if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || board[row][col] != '-') {
      return false; // Invalid move
    }
    board[row][col] = currentPlayer;
    return true;
  }

  public boolean checkWinner() {
    return checkRows() || checkCols() || checkDiagonals();
  }

  private boolean checkRows() {
    for (int i = 0; i < SIZE; i++) {
      if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
        return true;
      }
    }
    return false;
  }

  private boolean checkCols() {
    for (int j = 0; j < SIZE; j++) {
      if (board[0][j] != '-' && board[0][j] == board[1][j] && board[0][j] == board[2][j]) {
        return true;
      }
    }
    return false;
  }

  private boolean checkDiagonals() {
    return (board[0][0] != '-' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) ||
        (board[0][2] != '-' && board[0][2] == board[1][1] && board[0][2] == board[2][0]);
  }

  public void switchPlayer() {
    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
  }
}








/*
Instance Variables:
  SIZE: Represents the size of the board (3 or 4).
  board: A 2D array representing the game board.
  currentPlayer: Keeps track of the current player ('X' or 'O').
Constructor:
  Initializes the size of the board and creates a new board with all cells set to '-'.
Methods:
  initializeBoard(): Initializes the board with '-' in all cells.
  printBoard(): Prints the current state of the board.
  isBoardFull(): Checks if the board is full.
  makeMove(int row, int col): Allows a player to make a move at the specified row and column.
  checkWinner(): Checks if there is a winner by checking rows, columns, and diagonals.
  checkRows(), checkCols(), checkDiagonals(): Helper methods for checking win conditions.
  switchPlayer(): Switches the current player.
  */