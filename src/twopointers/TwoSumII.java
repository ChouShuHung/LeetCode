package twopointers;

import java.util.Arrays;

public class TwoSumII {

  public static void main(String[] args) {
    int[] nums = { 2, 7, 11, 15 };
    System.out.println(Arrays.toString(twoSum(nums, 9)));
  }

  public static int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;
    int twoSum;
    while (left < right) {
      twoSum = numbers[left] + numbers[right];
      if (twoSum > target) {
        right--;
      } else if (twoSum < target) {
        left++;
      } else {
        return new int[] { left+1, right+1 };
      }
    }
    return new int[] {};
  }
}
