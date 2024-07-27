package binarysearch;

public class BinarySearch {

  public static void main(String[] args) {
    int[] nums = { -1, 0, 3, 5, 9, 12 };
    System.out.println(search(nums, 13));
  }

  public static int search(int[] nums, int target) {
    return binarysearch(nums, target, 0, nums.length-1);
  }

  private static int binarysearch(int[] nums, int target, int low, int high) {
    if (high >= low) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (target < nums[mid]) {
        return binarysearch(nums, target, 0, mid - 1);
      } else {
        return binarysearch(nums, target, mid + 1, high);
      }
    }
    return -1;
  }
}
