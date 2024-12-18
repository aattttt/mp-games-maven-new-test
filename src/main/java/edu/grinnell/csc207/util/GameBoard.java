package edu.grinnell.csc207.util;

import java.io.PrintWriter;

/**
 * A GameBoard that holds moves made and calculates score.
 *
 * @author Moise (Moses) Milenge
 * @author Aaron (Aj) Trimble
 */
public class GameBoard {

  /**
   * String matrix used to hold moves.
   */
  Matrix<String> board;

  /**
   * Height of the board.
   */
  private int height;

  /**
   * Width of the board.
   */
  private int width;

  /**
   * Constructs the gameboard.
   *
   * @param w Height of the board.
   * @param h Width of the board.
   *
   */
  public GameBoard(int w, int h) {
    this.width = w;
    this.height = h;
    this.board = new MatrixV0<>(this.width, this.height, " ");
  } // GameBoard(int, int)

  /**
   * Returns if the space is filled or not.
   *
   * @param row    row of space to be checked.
   * @param column column of space to be checked.
   *
   * @return true if filled, false if not
   */
  public boolean isFilledSpace(int row, int column) {
    if (!this.board.get(row, column).equals(" ")) {
      PrintWriter pen = new PrintWriter(System.out, true);
      pen.println("That space is taken");
    } // if
    return !this.board.get(row, column).equals(" ");
  } // isFilledSpace(int, int)

  /**
   * Sets the given square to the given string.
   *
   * @param row    row selected.
   * @param column column selected.
   * @param piece  type of piece.
   *
   */
  public void set(int row, int column, String piece) {
    this.board.set(row, column, piece);
  } // set(int, int, String)

  /**
   * Gets the piece at a given space.
   *
   * @param row    row selected.
   * @param column column selected.
   *
   * @return the piece at the space.
   */
  public String get(int row, int column) {
    return this.board.get(row, column);
  } // get(int, int)

  /**
   * Gets the height of the board.
   *
   * @return the height of the board.
   */
  public int getHeight() {
    return this.height;
  } // getHeight()

  /**
   * Gets the width of the board.
   *
   * @return the width of the board.
   */
  public int getWidth() {
    return this.width;
  } // getWidth()

  /**
   * Calculates the number of four-in-a-rows for the given piece.
   *
   * @param piece row selected.
   *
   * @return the number of four-in-a-rows.
   */
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
          } // if
        } else {
          inLine = 0;
        } // else
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
          } // if
        } else {
          inLine = 0;
        } // else
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
          } // if
        } else {
          inLine = 0;
        } // else
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
          } // if
        } else {
          inLine = 0;
        } // else
      } // for (points for rows)
    } // for (diagonal top left corner)
    return score;
  } // getScore(String)

  /**
   * Prints the current board.
   *
   * @param pen used to print.
   * @param bol given to Matrix for path.
   *
   */
  public void print(PrintWriter pen, boolean bol) {
    Matrix.print(pen, this.board, bol);
  } // print(PrintWriter, boolean)
} // end class
