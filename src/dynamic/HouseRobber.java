package dynamic;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int prev = 0;
        int maxRob = 0;
        for(int n :nums){
            int curr = Math.max(prev+n, maxRob);
            prev = maxRob;
            maxRob = curr;
        }
        return maxRob;
    }
}
