package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {

  private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1},};
  static int maxCount = 0;

  public static void main(String[] args) {
    // int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
    int[][] grid = {{1, 2}};
    System.out.println(orangesRotting(grid));
  }

  private static int orangesRotting(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int fresh = 0;
    int count = 0;
    Queue<int[]> queue = new ArrayDeque<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2)
          queue.offer(new int[] {i, j});
        else if (grid[i][j] == 1)
          fresh++;
      }
    }

    while (!queue.isEmpty() && fresh != 0) {
      count++;
      int round = queue.size();
      for (int i = 0; i < round; i++) {
        int[] rotten = queue.poll();
        int row = rotten[0];
        int col = rotten[1];
        for (int[] dir : directions) {
          int x = row + dir[0];
          int y = col + dir[1];
          if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
            grid[x][y] = 2;
            queue.offer(new int[] {x, y});
            fresh--;
          }
        }
      }
    }
    return fresh == 0 ? count : -1;
  }
}
