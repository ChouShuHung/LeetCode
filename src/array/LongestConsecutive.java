package array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {

  public static void main(String[] args) {
    int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
    System.out.println(longestConsecutive(nums));
  }

  public static int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    int longest = 0;
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    for (int num : nums) {
      if (!set.contains(num - 1)) {
        int current = num;
        int count = 1;
        while (set.contains(current + 1)) {
          current++;
          count++;
        }
        longest = Math.max(longest, count);
      }
    }
    return longest;
  }
}
