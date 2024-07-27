package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

  public static void main(String[] args) {
    System.out.println(solveNQueens(4));
  }

  // using 3 set for solving this problem. ColSet, posDiagonal, negDiagonal
  public static List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<>();
    List<String> solution = new ArrayList<>();
    Set<Integer> colSet = new HashSet<>();
    Set<Integer> posDiagonal = new HashSet<>();
    Set<Integer> negDiagonal = new HashSet<>();
    queens(n, result, solution, colSet, posDiagonal, negDiagonal);
    return result;
  }

  private static void queens(
    int n,
    List<List<String>> result,
    List<String> solution,
    Set<Integer> colSet,
    Set<Integer> posDiagonal,
    Set<Integer> negDiagonal
  ) {
    if (solution.size() == n) {
      result.add(new ArrayList<>(solution));
    }
    int row = solution.size();
    for (int col = 0; col < n; col++) {
      if (
        colSet.contains(col) ||
        posDiagonal.contains(row + col) ||
        negDiagonal.contains(row - col)
      ) continue;
      solution.add(setQueenInRow(n, col));
      colSet.add(col);
      posDiagonal.add(row + col);
      negDiagonal.add(row - col);
      queens(n, result, solution, colSet, posDiagonal, negDiagonal);
      solution.remove(solution.size() - 1);
      colSet.remove(col);
      posDiagonal.remove(row + col);
      negDiagonal.remove(row - col);
    }
  }

  private static String setQueenInRow(int n, int col) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (i == col) builder.append("Q"); else builder.append(".");
    }
    return builder.toString();
  }
}
