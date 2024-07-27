package array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

  public static void main(String[] args) {
    int[] nums = { -1, 1, 0, -3, 3 };
    int[] nums2 = { 1, 2, 3, 4 };
    System.out.println(Arrays.toString(productExceptSelf(nums)));
    System.out.println(Arrays.toString(productExceptSelfOptimistic(nums2)));
  }

  public static int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int pre[] = new int[n];
    int suff[] = new int[n];
    pre[0] = 1;
    suff[n - 1] = 1;

    for (int i = 1; i < n; i++) {
      pre[i] = pre[i - 1] * nums[i - 1];
    }
    for (int i = n - 2; i >= 0; i--) {
      suff[i] = suff[i + 1] * nums[i + 1];
    }

    int ans[] = new int[n];
    for (int i = 0; i < n; i++) {
      ans[i] = pre[i] * suff[i];
    }
    return ans;
  }

  public static int[] productExceptSelfOptimistic(int[] nums) {
    int n = nums.length;
    int ans[] = new int[n];
    Arrays.fill(ans, 1);
    int prefix = 1;
    for (int i = 0; i < n; i++) {
      ans[i] *= prefix;
      prefix *= nums[i];
    }

    int postfix = 1;
    for (int j = nums.length - 1; j >= 0; j--) {
      ans[j] *= postfix;
      postfix *= nums[j];
    }
    return ans;
  }
}
