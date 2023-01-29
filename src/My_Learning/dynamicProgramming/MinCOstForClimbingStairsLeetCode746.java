package My_Learning.dynamicProgramming;

public class MinCOstForClimbingStairsLeetCode746 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Leetcode daily Problem
	int[] dp;

	public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		dp = new int[n];
		return Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
	}

	private int minCost(int[] cost, int n) {
		if (n < 0)
			return 0;
		if (n == 0 || n == 1)
			return cost[n];
		if (dp[n] != 0)
			return dp[n];
		dp[n] = cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
		return dp[n];
	}

}
