package dynamic;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, -2, 4};
        int[] nums2 = {-2, 0, -1};
        int[] nums3 =
                {0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0};
        System.out.println(maxProduct(nums1)); // 6
        System.out.println(maxProduct(nums2)); // 0
        System.out.println(maxProduct(nums3));
        // 10000000000
        // 1000000000
    }

    private static int maxProduct(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        double res = nums[0];
        double max = 1;
        double min = 1;

        for (int num : nums) {
            double n = num;
            double tmp = max * n;
            // ensure two negative value could be greater than max
            // also needs to check the num itself
            max = Math.max(n, Math.max(tmp, min * n));
            // store min which could be the smallest negative num
            min = Math.min(n, Math.min(tmp, min * n));
            // compare with previous result.
            res = Math.max(res, max);
        }
        return (int) res;
    }
}

