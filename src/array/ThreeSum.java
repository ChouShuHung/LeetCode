package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  public static void main(String[] args) {
    int[] nums = { 0, 0, 0, 0, 0, 0, 0 };
    System.out.println(threeSum(nums).toString());
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    // sorting O(nlogn) + O(n2)
    // space: O(1)~O(n)
    // Arrays.sort(nums);
    List<List<Integer>> allThreeSumResult = new ArrayList<>();
    for (int i = 0; i < nums.length - 1; i++) {
      var left = i + 1;
      var right = nums.length - 1;
      var total = 0;
      //Skip duplicate elements for 1
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      while (left < right) {
        total = nums[i] + nums[left] + nums[right];
        if (total > 0) {
          right--;
        } else if (total < 0) {
          left++;
        } else {
          allThreeSumResult.add(
            Arrays.asList(nums[i], nums[left], nums[right])
          );

          // Skip duplicate elements for left
          while (left < right && nums[left] == nums[left + 1]) {
            left++;
          }

          // Skip duplicate elements for right
          while (left < right && nums[right] == nums[right - 1]) {
            right--;
          }
          right--;
          left++;
        }
      }
    }
    return allThreeSumResult;
  }
}
