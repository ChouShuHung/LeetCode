package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetII {

  public static void main(String[] args) {
    int[] nums = new int[] { 1, 2, 2 };
    System.out.println(subsetsWithDup(nums).toString());
  }

  public static List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtracking(result, nums, new ArrayList<Integer>(), 0);
    return result;
  }

  // [[],[1],[1,2],[1,2,2],[2],[2,2]]
  private static void backtracking(
    List<List<Integer>> result,
    int[] nums,
    ArrayList<Integer> list,
    int index
  ) {
    result.add(new ArrayList<>(list));
    for (int i = index; i < nums.length; i++) {
      //skip the duplicate elements
      // if (i > index && nums[i] == nums[i - 1]) continue;
      list.add(nums[i]);
      backtracking(result, nums, list, i + 1);
      list.remove(list.size() - 1);
    }
  }
}
