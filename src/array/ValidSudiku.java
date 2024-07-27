package array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudiku {

  public static void main(String[] args) {
    char[][] board = {
      { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
      { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
      { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
      { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
      { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
      { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
      { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
      { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
      { '.', '.', '.', '.', '8', '.', '.', '7', '9' },
    };
    System.out.println(isValidSudoku(board));
  }

  public static boolean isValidSudoku(char[][] board) {
    Set<String> seen = new HashSet<>();
    for (int i = 0; i < 9; ++i) {
      for (int j = 0; j < 9; ++j) {
        char number = board[i][j];
        if (number != '.') if (
          !seen.add(number + " in row " + i) ||
          !seen.add(number + " in column " + j) ||
          !seen.add(number + " in block " + i / 3 + "-" + j / 3)
        ) return false;
      }
    }
    return true;
  }

  public static boolean selfPrac(char[][] board) {
    Set<String> vaildator = new HashSet<>();
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if (board[row][col] != '.') {
          if (
            !vaildator.add(board[row][col] + " in row " + row) ||
            !vaildator.add(board[row][col] + " in column " + col) ||
            !vaildator.add(board[row][col] + " in block " + row / 3 + "-" + col / 3)
          ) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
