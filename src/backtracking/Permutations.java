package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

  public static void main(String[] args) {
    int[] nums = new int[] { 1, 2, 3 };
    System.out.println(permute(nums).toString());
  }

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    // backtracking(result, nums, 0);
    perm(result, new ArrayList<>(), nums);
    return result;
  }

  //   private static void backtracking(
  //     List<List<Integer>> result,
  //     int[] nums,
  //     int index
  //   ) {
  //     if (index == nums.length) {
  //       List<Integer> list = new ArrayList<>();
  //       for (int i = 0; i < nums.length; i++) list.add(nums[i]);
  //       result.add(list);
  //       return;
  //     }

  //     for (int i = index; i < nums.length; i++) {
  //       swap(nums, index, i);
  //       backtracking(result, nums, index + 1);
  //       swap(nums, index, i);
  //     }
  //   }

  //   private static void swap(int[] nums, int index, int i) {
  //     int tmp = nums[index];
  //     nums[index] = nums[i];
  //     nums[i] = tmp;
  //   }

  public static void perm(
    List<List<Integer>> result,
    List<Integer> list,
    int[] nums
  ) {
    if (list.size() == nums.length) {
      result.add(new ArrayList<>(list));
      return;
    }
    for (int num : nums) {
      if (list.contains(num)) continue;
      list.add(num);
      perm(result, list, nums);
      list.remove(Integer.valueOf(num));
    }
  }
}
