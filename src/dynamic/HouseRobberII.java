package dynamic;

import java.util.Arrays;

public class HouseRobberII {
    public static void main(String[] args) {
        int[] nums1 = {2,3,2};
        int[] nums2 = {1,2,3,1};
        int[] nums3 = {1,2,3};
        System.out.println(rob(nums1));
        System.out.println(rob(nums2));
        System.out.println(rob(nums3));
    }
    public static int rob(int[] nums) {
        return Math.max( nums[0], 
        Math.max(
            robbering(Arrays.copyOfRange(nums, 0, nums.length-1)), 
            robbering(Arrays.copyOfRange(nums, 1, nums.length))));
    }
    private static int robbering(int[] nums) {
        int rob1 =0;
        int rob2 =0;
        for(int n:nums){
            int tmp = Math.max(rob1+n, rob2);
            rob1 = rob2;
            rob2 = tmp;
        }
        return rob2;
    }
}
