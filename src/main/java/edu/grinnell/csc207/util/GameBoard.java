package edu.grinnell.csc207.util;

import java.io.PrintWriter;


/**
 * A GameBoard that holds moves made and calculates score.
 *
 * @author Moise (Moses) Milenge
 * @author Aaron (Aj) Trimble
 */
public class GameBoard {

  /*
   * Fields
   */
  Matrix<String> board;
  int height;
  int width;

  /*
   * Constructor
   */
  public GameBoard(int width, int height) {
    this.width = width;
    this.height = height;
    this.board = new MatrixV0<>(width, height, " ");
  }

  /*
   * Methods
   */
  public boolean isFilledSpace(int row, int column) {
    if (!this.board.get(row, column).equals(" ")) {
      System.out.println("That space is taken");
    }
    return !this.board.get(row, column).equals(" ");
  }

  public void set(int row, int column, String piece) {
    this.board.set(row, column, piece);
  }

  public String get(int row, int column) {
    return this.board.get(row, column);
  }

  public int getHeight() {
    return this.height;
  }

  public int getWidth() {
    return this.width;
  }

  public int getScore(String piece) {
    int score = 0;
    // points by rows
    for (int i = 0; i < this.height; i++) {
      int inLine = 0;
      for (int j = 0; j < this.width; j++) {
        if (this.board.get(i, j).equals(piece)) {
          inLine++;
          if (inLine == 4) {
            inLine--;
            score++;
          }
        } else {
          inLine = 0;
        }
      } // for
    } // for (points for rows)
      // points by column
    for (int j = 0; j < this.width; j++) {
      int inLine = 0;
      for (int i = 0; i < this.height; i++) {
        if (this.board.get(i, j).equals(piece)) {
          inLine++;
          if (inLine == 4) {
            inLine--;
            score++;
          }
        } else {
          inLine = 0;
        }
      } // for
    } // for (points for column)
      // points by diagonal top left corner
    for (int x = 0; x < this.width; x++) {
      int inLine = 0;
      for (int i = x, j = 0; i < this.height && j < this.width; i++, j++) {
        if (this.board.get(i, j).equals(piece)) {
          inLine++;
          if (inLine == 4) {
            inLine--;
            score++;
          }
        } else {
          inLine = 0;
        }
      } // for (points for rows)
    } // for (diagonal top left corner)
      // points by diagonal top left corner
    for (int x = 1; x < this.width; x++) {
      int inLine = 0;
      for (int i = 0, j = x; i < this.height && j < this.width; i++, j++) {
        if (this.board.get(i, j).equals(piece)) {
          inLine++;
          if (inLine == 4) {
            inLine--;
            score++;
          }
        } else {
          inLine = 0;
        }
      } // for (points for rows)
    } // for (diagonal top left corner)
    return score;
  }

  public void print(PrintWriter pen, boolean bol) {
    Matrix.print(pen, this.board, bol);
  }

}