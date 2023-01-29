package My_Learning.DP_theory.ZeroOneKnapSackPattern;

import java.util.Arrays;

public class PartitionSubsetEqualSum {

	public static void main(String args[]) {

		int arr[] = { 2, 3, 3, 3, 4, 5 };
		int n = arr.length;

		if (canPartition(n, arr))
			System.out.println("The Array can be partitioned into two equal subsets");
		else
			System.out.println("The Array cannot be partitioned into two equal subsets");
	}
	
	//Recursive caller
	static boolean canPartitionRecursive(int n, int[] arr) {

		int totSum = 0;

		for (int i = 0; i < n; i++) {
			totSum += arr[i];
		}

		if (totSum % 2 == 1)
			return false;

		else {
			int k = totSum / 2;
			return subsetSumUtilRecursive(n - 1, k, arr);
		}
	}
	
	//Main recursive approach
	static boolean subsetSumUtilRecursive(int ind, int target, int arr[]) {
		if (target == 0)
			return true;

		if (ind == 0)
			return arr[0] == target;

		boolean notTaken = subsetSumUtilRecursive(ind - 1, target, arr);

		boolean taken = false;
		if (arr[ind] <= target)
			taken = subsetSumUtilRecursive(ind - 1, target - arr[ind], arr);

		return notTaken || taken;
	}

	// Memoization code
	static boolean canPartition(int n, int[] arr) {

		int totSum = 0;

		for (int i = 0; i < n; i++) {
			totSum += arr[i];
		}

		if (totSum % 2 == 1)
			return false;

		else {
			int k = totSum / 2;
			int dp[][] = new int[n][k + 1];
			for (int row[] : dp)
				Arrays.fill(row, -1);
			return subsetSumUtil(n - 1, k, arr, dp);
		}
	}

	static boolean subsetSumUtil(int ind, int target, int arr[], int[][] dp) {
		if (target == 0)
			return true;

		if (ind == 0)
			return arr[0] == target;

		if (dp[ind][target] != -1)
			return dp[ind][target] == 0 ? false : true;

		boolean notTaken = subsetSumUtil(ind - 1, target, arr, dp);

		boolean taken = false;
		if (arr[ind] <= target)
			taken = subsetSumUtil(ind - 1, target - arr[ind], arr, dp);
		dp[ind][target] = notTaken || taken ? 1 : 0;
		return notTaken || taken;
	}

	// Tabulation code
	static boolean subsetSumPartitionTabulation(int n, int[] arr) {

		int totSum = 0;

		for (int i = 0; i < n; i++) {
			totSum += arr[i];
		}

		if (totSum % 2 == 1)
			return false;

		else {
			int k = totSum / 2;
			boolean dp[][] = new boolean[n][k + 1];

			for (int i = 0; i < n; i++) {
				dp[i][0] = true;
			}

			if (arr[0] <= k)
				dp[0][arr[0]] = true;

			for (int ind = 1; ind < n; ind++) {
				for (int target = 1; target <= k; target++) {

					boolean notTaken = dp[ind - 1][target];

					boolean taken = false;
					if (arr[ind] <= target)
						taken = dp[ind - 1][target - arr[ind]];

					dp[ind][target] = notTaken || taken;
				}
			}

			return dp[n - 1][k];

		}
	}

	// Space Optimized
	static boolean subsetSumPartitionSpaceOptimized(int n, int[] arr) {

		int totSum = 0;

		for (int i = 0; i < n; i++) {
			totSum += arr[i];
		}

		if (totSum % 2 == 1)
			return false;

		else {
			int k = totSum / 2;
			boolean prev[] = new boolean[k + 1];

			prev[0] = true;

			if (arr[0] <= k)
				prev[arr[0]] = true;

			for (int ind = 1; ind < n; ind++) {
				boolean cur[] = new boolean[k + 1];
				cur[0] = true;
				for (int target = 1; target <= k; target++) {
					boolean notTaken = prev[target];

					boolean taken = false;
					if (arr[ind] <= target)
						taken = prev[target - arr[ind]];

					cur[target] = notTaken || taken;
				}
				prev = cur;
			}

			return prev[k];
		}
	}
}
