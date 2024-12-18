
package edu.grinnell.csc207.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UserInterface {
  public static void main(String[] args) throws IOException {
    int width = 8;
    int height = 8;
    int row = -1;
    int column = -1;
    PrintWriter pen = new PrintWriter(System.out, true);
    BufferedReader eyes = new BufferedReader(new InputStreamReader(System.in));
    System.out.println(
        "Player 1 places X and player 2 places O. Each player places two pieces per turn. The player with the most four-in-a-rows at the end wins.");
    GameBoard gameBoard = new GameBoard(width, height);
    gameBoard.print(pen, true);
    for (int i = 0; i < ((height * width) / 4); i++) {
      GameLogic.playTurn(gameBoard, row, column, 1, eyes, pen, height, "first");
      GameLogic.playTurn(gameBoard, row, column, 1, eyes, pen, height, "second");
      gameBoard.print(pen, true);
      GameLogic.playTurn(gameBoard, row, column, 2, eyes, pen, height, "first");
      GameLogic.playTurn(gameBoard, row, column, 2, eyes, pen, height, "second");
      gameBoard.print(pen, true);
    }
    GameLogic.getWinner(gameBoard);
  }
}