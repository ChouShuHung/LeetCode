package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

  public static void main(String[] args) {
    List<List<Integer>> combinationSum = combinationSum(
      new int[] { 2, 3, 6, 7 },
      7
    );
    System.out.println(combinationSum.toString());
  }

  public static List<List<Integer>> combinationSum(
    int[] candidates,
    int target
  ) {
    List<List<Integer>> result = new ArrayList<>();
    backtracking(result, candidates, 0, new ArrayList<>(), target);
    return result;
  }

  private static void backtracking(
    List<List<Integer>> result,
    int[] candidates,
    int index,
    List<Integer> list,
    int target
  ) {
    if (target < 0 || index >= candidates.length) {
      return;
    }
    if (target == 0) {
      result.add(new ArrayList<>(list));
      return;
    }
    for (int i = index; i < candidates.length; i++) {
      //   if (candidates[index] <= target) {
      list.add(candidates[i]);
      backtracking(result, candidates, i, list, target - candidates[i]);
      list.remove(list.size() - 1);
      //   }
    }
    // backtracking(result, candidates, index + 1, list, target);
  }

  
}
