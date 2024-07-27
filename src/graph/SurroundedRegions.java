package graph;

import java.util.Arrays;

public class SurroundedRegions {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    public static void solve(char[][] board) {
        // find the unsurrounded region and replace others to X
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            dfs(i, 0, board);
            dfs(i, n - 1, board);
        }
        for (int i = 0; i < n; i++) {
            dfs(0, i, board);
            dfs(m - 1, i, board);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] == 'U' ? 'O' : 'X';
            }
        }
    }

    private static void dfs(int row, int col, char[][] board) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != 'O')
            return;

        board[row][col] = 'U';

        for (int[] dir : directions) {
            dfs(row + dir[0], col + dir[1], board);
        }
    }
}
