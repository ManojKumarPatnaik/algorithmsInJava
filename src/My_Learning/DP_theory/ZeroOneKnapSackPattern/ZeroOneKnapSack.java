package My_Learning.DP_theory.ZeroOneKnapSackPattern;

public class ZeroOneKnapSack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] wt = { 1, 3, 4, 5 }; // Item weight array
//		int[] val = { 1, 4, 5, 7 }; // Item value array
//		int W = 7; // Knapsack weight
//		int n = wt.length;

		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;

		// In 0-1 Knapsack
		// task is to maximize the profit by picking up the items
		// Here one item is either taken or not completely, no concept of partial take

		int ans = knapSack(wt, val, W, n);
		System.out.println("Max Profit Using Recursive approach :: " + ans);

		int ans1 = knapSackMemoization(wt, val, W, n);
		System.out.println("Max Profit Using Memoization approach on recursive solution :: " + ans1);

		int ans2 = knapSackMemoization(wt, val, W, n);
		System.out.println("Max Profit Using Top Down Approach on recursive solution :: " + ans2);
	}

	// recursive approach
	private static int knapSack(int[] wt, int[] val, int W, int n) {

		// base condition
		if (W == 0 || n == 0)
			return 0;

		if (wt[n - 1] <= W) {
			return Math.max(val[n - 1] + knapSack(wt, val, W - wt[n - 1], n - 1), knapSack(wt, val, W, n - 1));
		} else {
			return knapSack(wt, val, W, n - 1);
		}

	}
	
	// Leetcode daily solution	
	// Memoization - storing the answers
	public static int knapSackMemoization(int[] wt, int[] val, int W, int n) {

		// making matrix with changing variable
		int[][] dp = new int[n + 1][W + 1];

		if (W == 0 || n == 0) {
			return dp[n][W] = 0;
		}

		if (dp[n][W] != 0) {
			return dp[n][W];
		}

		if (wt[n - 1] <= W) {
			// wt of current item is less then we can pick or not pic
			return dp[n][W] = Math.max(val[n - 1] + knapSackMemoization(wt, val, W - wt[n - 1], n - 1),
					knapSackMemoization(wt, val, W, n - 1));

		} else {
			return dp[n][W] = knapSackMemoization(wt, val, W, n - 1);
		}

	}

	// Top down approach
	public static int knapSackDP(int[] wt, int[] val, int W, int n) {

		// making matrix with changing variable
		int[][] dp = new int[n + 1][W + 1];

		// Initialization
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < W + 1; j++) {
				if (i == 0)
					dp[i][j] = 0;

				if (j == 0)
					dp[i][j] = 0;
			}
		}

		if (dp[n][W] != 0) {
			return dp[n][W];
		}

		if (wt[n - 1] <= W) {
			// wt of current item is less then we can pick or not pic
			return dp[n][W] = Math.max(val[n - 1] + dp[n - 1][W - wt[n - 1]], dp[n - 1][W]);

		} else {
			return dp[n][W] = dp[n - 1][W];
		}

	}
}
