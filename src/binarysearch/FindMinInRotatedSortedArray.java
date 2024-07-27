package binarysearch;

public class FindMinInRotatedSortedArray {

  public static void main(String[] args) {
    int[] nums = { 3, 1, 2 };
    System.out.println(findMin(nums));
  }

  public static int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      if (nums[left] <= nums[right]) {
        return nums[left];
      }
      int mid = (right + left) / 2;
      if (nums[mid] >= nums[left]) {
        //search right
        left = mid + 1;
      } else {
        //search left
        right = mid;
      }
    }
    return 0;
  }
}
