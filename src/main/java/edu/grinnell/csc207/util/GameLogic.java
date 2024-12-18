package edu.grinnell.csc207.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class GameLogic {

  static void playTurn(GameBoard gameBoard, int row, int column, int player, BufferedReader eyes,
      PrintWriter pen, int limit, String round) throws IOException {
    do {
      row = IOUtils.readInt(pen, eyes, "Player " + player + " " + round + " row ", 0, limit);
      System.out.println(row);
      column = IOUtils.readInt(pen, eyes, "Player " + player + " " + round + " column ", 0,
          limit);
      System.out.println(column);
    } while (gameBoard.isFilledSpace(row, column));
    if (player == 1) {
      gameBoard.set(row, column, "X");
    } else {
      gameBoard.set(row, column, "O");
    }
  }

  static void getWinner(GameBoard gameBoard) {
    int x = gameBoard.getScore("X");
    int o = gameBoard.getScore("O");
    System.out.println("Player 1 score: " + x);
    System.out.println("Player 2 score: " + o);
    if (x > o) {
      System.out.println("Player 1 wins!");
    } else if (x < o) {
      System.out.println("Player 2 wins!");
    } else {
      System.out.println("Tie!");
    }
  }

}