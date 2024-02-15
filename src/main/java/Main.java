//Jack Gillis
//TicTacToe
//2/14/24
//Period 5

import java.util.Scanner;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to Tic Tac Toe!");

    // Prompts the user to enter the size of the board (3 or 4).
    System.out.print("Enter the size of the board (3 or 4): ");
    int size = scanner.nextInt();

    // Creates instances of TicTacToe and two Player objects.
    TicTacToe game = new TicTacToe(size);
    Player player1 = new Player('X');
    Player player2 = new Player('O');

    Player currentPlayer = player1;

    // Starts the game loop.
    while (true) {
      System.out.println("Current board:");
      //Prints the current state of the board.
      game.printBoard();

      System.out.println("Player " + currentPlayer.getSymbol() + "'s turn");

      // Prompts the current player to make a move.
      System.out.print("Enter row and column separated by an enter: ");
      int row = scanner.nextInt();
      int col = scanner.nextInt();

      // Validates the move and updates the board.
      if (!game.makeMove(row, col)) {
        System.out.println("Invalid move. Try again.");
        continue;
      }

      // Checks if there is a winner or a draw.
      if (game.checkWinner()) {
        System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
        break;
      } else if (game.isBoardFull()) {
        System.out.println("It's a draw!");
        break;
      }

      // Switches the current player and repeats the loop if the game is not over.
      game.switchPlayer();
      currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    scanner.close();
  }
}



