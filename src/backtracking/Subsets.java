package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

  public static void main(String[] args) {
    System.out.println(subsets(new int[] { 1, 2, 3 }));
  }

  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    backtracking(ans, 0, nums, list);
    return ans;
  }

  //[[1, 2, 3], [1, 2], [1, 3], [1], [2, 3], [2], [3], []]
  public static void backtracking(
    List<List<Integer>> result,
    int index,
    int[] nums,
    List<Integer> list
  ) {
    // if (index >= nums.length) {
    //   result.add(new ArrayList<>(list));
    // } else {
    //   // add the element and start the recursive call
    //   list.add(nums[index]);
    //   backtracking(result, index + 1, nums, list);
    //   // remove the element and do the backtracking call.
    //   list.remove(list.size() - 1);
    //   backtracking(result, index + 1, nums, list);
    // }
    result.add(new ArrayList<>(list));
    for (int i = index; i < nums.length; i++) {
      // duplication, i is greater than index when run the loop to increase i
      // if (i > index && nums[i] == nums[i - 1]) {
      //   continue;
      // }
      list.add(nums[i]);
      backtracking(result, i + 1, nums, list);
      list.remove(list.size() - 1);
    }
  }
}
