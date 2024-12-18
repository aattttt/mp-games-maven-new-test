package edu.grinnell.csc207.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Handles the flow a turn and finds the winner.
 *
 * @author Moise (Moses) Milenge
 * @author Aaron (Aj) Trimble
 */
public class TurnProcessing {

  static void playTurn(GameBoard gameBoard, int row, int column, int player, BufferedReader eyes,
      PrintWriter pen, int limit, String round) throws IOException {
    do {
      row = IOUtils.readInt(pen, eyes, "Player " + player + " " + round + " row ", 0, limit);
      pen.println(row);
      column = IOUtils.readInt(pen, eyes, "Player " + player + " " + round + " column ", 0,
          limit);
      pen.println(column);
    } while (gameBoard.isFilledSpace(row, column));
    if (player == 1) {
      gameBoard.set(row, column, "X");
    } else {
      gameBoard.set(row, column, "O");
    } // else
  } // Turn Processing

  static void getWinner(GameBoard gameBoard) {
    PrintWriter pen = new PrintWriter(System.out, true);
    int x = gameBoard.getScore("X");
    int o = gameBoard.getScore("O");
    pen.println("Player 1 score: " + x);
    pen.println("Player 2 score: " + o);
    if (x > o) {
      pen.println("Player 1 wins!");
    } else if (x < o) {
      pen.println("Player 2 wins!");
    } else {
      pen.println("Tie!");
    } // else
  } // getWinner(GameBoard)
} // end class
