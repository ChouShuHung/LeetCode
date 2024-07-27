package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxAreaOfIsland {

  private static final int[][] directions = {
    { 1, 0 },
    { -1, 0 },
    { 0, 1 },
    { 0, -1 },
  };

  public static void main(String[] args) {
    int[][] grid =
      // {
      //   { 0, 1, 1, 0, 1 },
      //   { 1, 0, 1, 0, 1 },
      //   { 0, 1, 1, 0, 1 },
      //   { 0, 1, 0, 0, 1 },
      // };
      {
        { 1, 1, 0, 0, 0 },
        { 1, 1, 0, 0, 0 },
        { 0, 0, 0, 1, 1 },
        { 0, 0, 0, 1, 1 },
      };
    System.out.println(maxAreaOfIsland(grid));
  }

  public static int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    int maxAreaOfIsland = 0;
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (grid[row][col] == 1) {
          int islands = bfs(grid, row, col);
          if (islands > maxAreaOfIsland) maxAreaOfIsland = islands;
        }
      }
    }

    return maxAreaOfIsland;
  }

  private static int bfs(int[][] grid, int row, int col) {
    int lands = 0;
    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[] { row, col });

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      int x = curr[0];
      int y = curr[1];
      if (
        x < 0 ||
        x >= grid.length ||
        y < 0 ||
        y >= grid[0].length ||
        grid[x][y] != 1
      ) continue;

      lands++;
      grid[x][y] = 0;

      for (int[] dir : directions) {
        int nx = x + dir[0];
        int ny = y + dir[1];
        if (
          nx >= 0 &&
          nx < grid.length &&
          ny >= 0 &&
          ny < grid[0].length &&
          grid[nx][ny] == 1
        ) queue.offer(new int[] { nx, ny });
      }
    }

    return lands;
  }
}
