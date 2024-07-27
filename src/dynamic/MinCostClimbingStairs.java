package dynamic;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        int[] cost1 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
        System.out.println(minCostClimbingStairs(cost1));
    }

    public static int minCostClimbingStairs(int[] cost) {
        // one is prev and prev min
        // two is prev min
        // cost[i] + Math.min(one,two) is current min
        int one = 0;
        int two = 0;
        // the reason why loop backwards is based on reaching the top
        for (int i = cost.length - 1; i >= 0; i--) {
            cost[i] = cost[i] + Math.min(one, two);
            one = two;
            two = cost[i];
        }
        return Math.min(one, two);
    }
}
