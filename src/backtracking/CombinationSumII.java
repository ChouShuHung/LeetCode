package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

  public static void main(String[] args) {
    System.out.println(combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
  }

  public static List<List<Integer>> combinationSum2(
    int[] candidates,
    int target
  ) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    backtracking(result, candidates, new ArrayList<>(), 0, target);
    return result;
  }

  private static void backtracking(
    List<List<Integer>> result,
    int[] candidates,
    List<Integer> list,
    int index,
    int target
  ) {
    if (target == 0) {
      result.add(new ArrayList<>(list));
    }
    for (int i = index; i < candidates.length; i++) {
      if (i != index && candidates[i] == candidates[i - 1]) continue;
      if (candidates[i] > target) break;
      list.add(candidates[i]);
      backtracking(result, candidates, list, i + 1, target - candidates[i]);
      list.remove(list.size() - 1);
    }
  }
}
