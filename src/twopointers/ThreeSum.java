package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  public static void main(String[] args) {
    int[] nums = { -1, 0, 1, 2, -1, -4 };
    threeSum(nums).stream().forEach(System.out::println);
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> threeSums = new ArrayList<>();

    for (int i = 0; i < nums.length - 1; i++) {
      int left = i + 1;
      int right = nums.length - 1;
      int threeSum;
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }

      while (left < right) {
        threeSum = nums[i] + nums[left] + nums[right];
        if (threeSum > 0) {
          right--;
        } else if (threeSum < 0) {
          left++;
        } else {
          threeSums.add(Arrays.asList(nums[i], nums[left], nums[right]));

          while (left < right && nums[left] == nums[left + 1]) {
            left++;
          }
          while (left < right && nums[right] == nums[right - 1]) {
            right--;
          }
          left++;
          right--;
        }
      }
    }

    return threeSums;
  }
}
