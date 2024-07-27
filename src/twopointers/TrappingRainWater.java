package twopointers;

public class TrappingRainWater {

  public static void main(String[] args) {
    int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
    System.out.println(trap(height));
  }

  public static int trap(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int maxLeft = 0;
    int maxRight = 0;
    int waterTrapped = 0;
    while (left < right) {
      maxLeft = Math.max(maxLeft, height[left]);
      maxRight = Math.max(maxRight, height[right]);
      if (maxLeft == Math.min(maxLeft, maxRight)) {
        if ((maxLeft - height[left]) > 0) {
          waterTrapped += maxLeft - height[left];
        }
        left++;
      } else {
        if ((maxRight - height[right]) > 0) {
          waterTrapped += maxRight - height[right];
        }
        right--;
      }
    }
    return waterTrapped;
  }
}
