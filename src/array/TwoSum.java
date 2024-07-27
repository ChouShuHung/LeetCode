package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TwoSum {

  public static void main(String[] args) {
    int[] nums = { 2, 7, 11, 15 };
    // int[] twoSum = twoSum(nums, 9);
    int[] twoSum = twoSum(nums, 9);
    if (Optional.of(twoSum).isPresent()) {
      Arrays.stream(twoSum).forEach(System.out::println);
    }
  }

  public static int[] twoSumBF(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] { i, j };
        }
      }
    }
    return null;
  }

  public static int[] twoSumWith2HashMap(int[] nums, int target) {
    Map<Integer, Integer> numMap = new HashMap<>();
    int n = nums.length;

    // Build the hash table
    for (int i = 0; i < n; i++) {
      numMap.put(nums[i], i);
    }

    // Find the complement
    for (int i = 0; i < n; i++) {
      int complement = target - nums[i];
      if (numMap.containsKey(complement) && numMap.get(complement) != i) {
        return new int[] { i, numMap.get(complement) };
      }
    }

    return new int[] {};
  }

  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (numMap.containsKey(complement)) {
        return new int[] { numMap.get(complement), i};
      }
      numMap.put(nums[i], i);
    }
    return new int[] {};
  }
}
