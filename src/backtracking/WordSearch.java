package backtracking;

public class WordSearch {

  public static void main(String[] args) {
    char[][] board = new char[][] {
      { 'A', 'B', 'C', 'E' },
      { 'S', 'F', 'C', 'S' },
      { 'A', 'D', 'E', 'E' },
    };
    String word = "ABCCED";
    System.out.println(exist(board, word));
  }

  public static boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (dfs(board, word, i, j, 0)) return true;
      }
    }
    return false;
  }

  // check left/right row
  // check top/bottom col
  // cword is empty(check the last word) and can also find the cword, returns true
  // cannot find the matched cword then return false;

  private static boolean dfs(
    char[][] board,
    String word,
    int row,
    int col,
    int cIndex
  ) {
    // all words are checked.
    if (cIndex >= word.length()) return true;
    // if left and right has no matched word
    // if top and bottom has no matched word
    // if the word is not matched
    if (
      row < 0 ||
      col < 0 ||
      row >= board.length ||
      col >= board[0].length ||
      board[row][col] != word.charAt(cIndex)
    ) return false;

    boolean matched = false;
    if (board[row][col] == word.charAt(cIndex)) {
      // marked as used
      board[row][col] += 100;
      matched =
        dfs(board, word, row + 1, col, cIndex + 1) ||
        dfs(board, word, row - 1, col, cIndex + 1) ||
        dfs(board, word, row, col + 1, cIndex + 1) ||
        dfs(board, word, row, col - 1, cIndex + 1);
      board[row][col] -= 100;
    }
    return matched;
  }

  public static boolean exist1(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (check(board, word, i, j, m, n, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean check(
    char[][] board,
    String word,
    int i,
    int j,
    int m,
    int n,
    int cur
  ) {
    if (cur >= word.length()) return true;
    if (
      i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(cur)
    ) return false;
    boolean exist = false;
    if (board[i][j] == word.charAt(cur)) {
      board[i][j] += 100;
      exist =
        check(board, word, i + 1, j, m, n, cur + 1) ||
        check(board, word, i, j + 1, m, n, cur + 1) ||
        check(board, word, i - 1, j, m, n, cur + 1) ||
        check(board, word, i, j - 1, m, n, cur + 1);
      board[i][j] -= 100;
    }
    return exist;
  }
}
