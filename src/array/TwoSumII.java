package array;

import java.util.Arrays;

public class TwoSumII {

  public static void main(String[] args) {
    int[] numbers = { 2, 7, 11, 15 };
    Arrays.stream(twoSum(numbers, 9)).forEach(System.out::println);
  }

  public static int[] twoSum(int[] numbers, int target) {
    var leftPointer = 0;
    var rightPointer = numbers.length - 1;
    var twoSum = 0;
    while (leftPointer < rightPointer) {
      twoSum = numbers[leftPointer] + numbers[rightPointer];
      if (twoSum == target) {
        return new int[] { leftPointer, rightPointer };
      } else {
        if (target > twoSum) {
            leftPointer++;
        } else {
            rightPointer--;
        }
      }
    }
    return new int[] {};
  }
}
