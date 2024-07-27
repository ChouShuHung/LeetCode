package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWataerFlow {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};
        System.out.println(pacificAtlantic(heights).toString());
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int min = Integer.MIN_VALUE;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> result = new ArrayList<>();
        // DFS - check for the col of ocean
        for (int i = 0; i < n; i++) {
            dfs(0, i, min, heights, pacific);
            dfs(m - 1, i, min, heights, atlantic);
            }
        // DFS - check for the row of ocean
        for (int i = 0; i < m; i++) {
            dfs(i, 0, min, heights, pacific);
            dfs(i, n - 1, min, heights, atlantic);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private static void dfs(int i, int j, int prev, int[][] heights, boolean[][] ocean) {
        if (i < 0 || i >= ocean.length || j < 0 || j >= ocean[0].length
                || heights[i][j] < prev || ocean[i][j])
            return;
        ocean[i][j] = true;
        for (int[] dir : directions) {
            dfs(i + dir[0], j + dir[1], heights[i][j], heights, ocean);
        }
    }
}
