package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 1 };
    System.out.println(containsDuplicateBySet(nums));
  }

  public static boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) return true;
    }
    return false;
  }

  public static boolean containsDuplicateBySet(int[] nums) {
    Set<Integer> duplicateNumSet = new HashSet<>();
    for (int num : nums) {
      if (duplicateNumSet.contains(num)) {
        return true;
      } else {
        duplicateNumSet.add(num);
      }
    }
    return false;
  }
}
