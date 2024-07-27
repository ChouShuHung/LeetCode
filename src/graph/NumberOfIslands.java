package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {

  private static int[][] direction = {
    { 1, 0 },
    { -1, 0 },
    { 0, 1 },
    { 0, -1 },
  };

  public static void main(String[] args) {
    char[][] grid = {
      { '1', '1', '0', '0', '0' },
      { '1', '1', '0', '0', '0' },
      { '0', '0', '1', '0', '0' },
      { '0', '0', '0', '1', '1' },
    };
    System.out.println(numIslands(grid));
  }

  public static int numIslands(char[][] grid) {
    int numIslands = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          numIslands++;
          breathFirstSearch(grid, i, j);
        }
      }
    }
    return numIslands;
  }

  private static void breathFirstSearch(char[][] grid, int i, int j) {
    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[] { i, j });

    // leverage queue to replace connected land from 1 to 0
    while (!queue.isEmpty()) {
      int[] curt = queue.poll();
      int x = curt[0];
      int y = curt[1];
      if (
        x < 0 ||
        x >= grid.length ||
        y < 0 ||
        y >= grid[0].length ||
        grid[x][y] != '1'
      ) continue;

      grid[x][y] = '0';

      for (int[] d : direction) {
        int nx = x + d[0];
        int ny = y + d[1];
        if (
          nx >= 0 &&
          nx < grid.length &&
          ny >= 0 &&
          ny < grid[0].length &&
          grid[nx][ny] == '1'
        ) {
          queue.offer(new int[] { nx, ny });
        }
      }
    }
  }

  /**
   *  Breadth-First Search (BFS):
   *  The BFS approach involves using a queue to systematically explore all cells of each island.
   *  We'll iterate through each cell in the grid. When encountering a '1' (indicating land),
   *  we'll use BFS to explore all connected land cells and mark them as visited.
   *
   *  BFS Function:
   *  Use a queue to perform BFS starting from each unvisited land cell ('1').
   *  Initialize a queue with the starting cell.
   *  While the queue is not empty, dequeue a cell, mark it as visited, and enqueue its neighboring land cells (up, down, left, right).
   *  Continue until all connected land cells of the current island are visited.
   *
   *  Main Function:
   *  Iterate through each cell in the grid.
   *  If encountering an unvisited '1', increment the island count and trigger BFS to explore and mark all connected land cells of this island.
   * @param grid
   * @return
   */
  public static int numIslands2(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int numIslands = 0;
    int m = grid.length;
    int n = grid[0].length;
    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          numIslands++;
          Queue<int[]> queue = new ArrayDeque<>();
          queue.offer(new int[] { i, j });

          while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1') {
              continue;
            }

            grid[x][y] = '0'; // mark as visited

            for (int[] dir : directions) {
              int nx = x + dir[0];
              int ny = y + dir[1];
              if (
                nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1'
              ) {
                queue.offer(new int[] { nx, ny });
              }
            }
          }
        }
      }
    }

    return numIslands;
  }

  /**
   * Both DFS and BFS are used to explore and mark connected land cells.
   * DFS uses a recursive approach, while BFS employs an iterative queue-based approach.
   * DFS can lead to deep recursion (which might cause stack overflow for extremely large grids), while BFS uses a queue, which can be more suitable for larger grids.
   * Time complexity for both methods is O(m * n) where m is the number of rows and n is the number of columns in the grid.
   * @param grid
   * @return
   */
  public int numIslands1(char[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          count++;
        }
      }
    }
    return count;
  }

  public void dfs(char[][] grid, int i, int j) {
    if (
      i < 0 ||
      j < 0 ||
      i >= grid.length ||
      j >= grid[0].length ||
      grid[i][j] == '0'
    ) {
      return;
    }
    grid[i][j] = '0';
    dfs(grid, i + 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i - 1, j);
    dfs(grid, i, j - 1);
  }
}
