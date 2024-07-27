package twopointers;

public class ContainerWithMostWater {

  public static void main(String[] args) {
    int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
    System.out.println(maxArea(heights));
  }

  public static int maxArea(int[] height) {
    if (height == null || height.length < 1) return -1;
    int left = 0;
    int right = height.length - 1;
    int maxContainer = 0;
    int minHeight = 0;
    while (left < right) {
      minHeight = Math.min(height[right], height[left]);
      maxContainer = Math.max(minHeight * (right - left), maxContainer);
      while (height[left] <= minHeight && left < right) left++;
      while (height[right] <= minHeight && left < right) right--;
    }
    return maxContainer;
  }
}
