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

    System.out.print("Enter the size of the board (3 or 4): ");
    int size = scanner.nextInt();

    TicTacToe game = new TicTacToe(size);
    Player player1 = new Player('X');
    Player player2 = new Player('O');

    Player currentPlayer = player1;

    while (true) {
      System.out.println("\nCurrent board:");
      game.printBoard();

      System.out.println("\nPlayer " + currentPlayer.getSymbol() + "'s turn");
      System.out.print("Enter row and column separated by an enter: ");
      int row = scanner.nextInt();
      int col = scanner.nextInt();

      if (!game.makeMove(row, col)) {
        System.out.println("Invalid move. Try again.");
        continue;
      }

      if (game.checkWinner()) {
        System.out.println("\nPlayer " + currentPlayer.getSymbol() + " wins!");
        break;
      } else if (game.isBoardFull()) {
        System.out.println("\nIt's a draw!");
        break;
      }

      game.switchPlayer();
      currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    scanner.close();
  }
}