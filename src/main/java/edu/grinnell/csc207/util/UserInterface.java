
package edu.grinnell.csc207.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Handles user input and the flow of a game.
 *
 * @author Moise (Moses) Milenge
 * @author Aaron (Aj) Trimble
 */
public class UserInterface {
  /**
   * Handles user input and the flow of a game.
   *
   * @param args command line input from the user.
   *
   */
  public static void main(String[] args) throws IOException {
    int row = -1;
    int column = -1;
    int width;
    int height;
    PrintWriter pen = new PrintWriter(System.out, true);
    BufferedReader eyes = new BufferedReader(new InputStreamReader(System.in));
    String prompt = "Type L for a long game or S for a short game \n";
    String[] commands = {"L", "S", "l", "s"};
    String gameLength = IOUtils.readCommand(pen, eyes, prompt, commands);
    if (gameLength.equalsIgnoreCase("l")) {
      width = 16;
      height = 16;
    } else {
      width = 8;
      height = 8;
    } // else
    pen.println(
        "Player 1 places X and player 2 places O. Each player places two pieces per turn."
            + " The player with the most four-in-a-rows at the end wins.");
    GameBoard gameBoard = new GameBoard(width, height);
    gameBoard.print(pen, true);
    for (int i = 0; i < ((height * width) / 4); i++) {
      TurnProcessing.playTurn(gameBoard, row, column, 1, eyes, pen, height, "first");
      TurnProcessing.playTurn(gameBoard, row, column, 1, eyes, pen, height, "second");
      gameBoard.print(pen, true);
      TurnProcessing.playTurn(gameBoard, row, column, 2, eyes, pen, height, "first");
      TurnProcessing.playTurn(gameBoard, row, column, 2, eyes, pen, height, "second");
      gameBoard.print(pen, true);
    } // for
    TurnProcessing.getWinner(gameBoard);
  } // main(String[])
} // end class
