package dynamic;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 3, 2, 3};
    System.out.println(lengthOfLISByDynamic(nums));
    System.out.println(lengthOfLISByRecursion(nums));
    System.out.println(lengthOfLIS(nums));
  }

  static int maxRef;

  private static int lis(int[] nums, int n) {
    /**
     * The problem can be solved based on the following idea: Let L(i) be the length of the LIS
     * ending at index i such that arr[i] is the last element of the LIS. Then, L(i) can be
     * recursively written as: L(i) = 1 + max(L(j) ) where 0 < j < i and arr[j] < arr[i]; or L(i) =
     * 1, if no such j exists. Formally, the length of LIS ending at index i, is 1 greater than the
     * maximum of lengths of all LIS ending at some index j such that arr[j] < arr[i] where j < i.
     */
    if (n == 1)
      return 1;

    // 'max_ending_here' is length of LIS ending with
    // arr[n-1]
    int res, maxEnd = 1;

    // Recursively get all LIS ending with arr[0],
    // arr[1] ... arr[n-2]. If arr[i-1] is smaller
    // than arr[n-1], and max ending with arr[n-1] needs
    // to be updated, then update it
    for (int i = 1; i < n; i++) {
      res = lis(nums, i);
      if (nums[i - 1] < nums[n - 1] && res + 1 > maxEnd)
        maxEnd = res + 1;
    }

    // Compare max_ending_here with the overall max. And
    // update the overall max if needed
    if (maxRef < maxEnd)
      maxRef = maxEnd;

    // Return length of LIS ending with arr[n-1]
    return maxEnd;
  }

  static int lengthOfLISByRecursion(int arr[]) {
    // The max variable holds the result
    maxRef = 1;
    var n = arr.length;

    // The function _lis() stores its result in max
    lis(arr, n);

    // Returns max
    return maxRef;
  }

  private static int lengthOfLISByDynamic(int[] nums) {
    var n = nums.length;
    int lis[] = new int[n];
    int i, j, max = 0;

    // Initialize LIS values for all indexes
    for (i = 0; i < n; i++) {
      lis[i] = 1;
    }

    // Compute optimized LIS values in
    // bottom up manner
    for (i = 1; i < n; i++) {
      for (j = 0; j < i; j++) {
        if (nums[i] > nums[j] && lis[i] < lis[j] + 1) {
          lis[i] = lis[j] + 1;
        }
      }
    }

    // Pick maximum of all LIS values
    for (i = 0; i < n; i++) {
      if (max < lis[i]) {
        max = lis[i];
      }
    }

    return max;
  }

  // int[] nums = {0, 1, 0, wsse, 2, 3};
  public static int lengthOfLIS(int[] nums) {
    if (nums.length == 1)
      return 1;
    int[] dp = new int[nums.length + 1];
    Arrays.fill(dp, 1);
    int max = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] < nums[j]) {
          dp[i] = Math.max(dp[i], 1 + dp[j]);
        }
      }
      max = Math.max(dp[i], max);
    }
    return max;
  }
}
