package My_Learning.DP_theory.ZeroOneKnapSackPattern;

import java.util.Arrays;

public class TotalNoWaysToUseCoinLeetcode518 {
	public static void main(String args[]) {

		int arr[] = { 1, 2, 3 };
		int target = 4;

		int n = arr.length;

		System.out.println("The total number of ways is " + countWaysToMakeChange(arr, n, target));
	}

	// Recursive code
	static long countWaysToMakeChangeUtilRecursive(int[] arr, int ind, int T) {

		if (ind == 0) {
			if (T % arr[0] == 0)
				return 1;
			else
				return 0;
		}

		long notTaken = countWaysToMakeChangeUtilRecursive(arr, ind - 1, T);

		long taken = 0;
		if (arr[ind] <= T)
			taken = countWaysToMakeChangeUtilRecursive(arr, ind, T - arr[ind]);

		return notTaken + taken;
	}

	// Memoization code
	static long countWaysToMakeChange(int[] arr, int n, int T) {

		long dp[][] = new long[n][T + 1];
		for (long row[] : dp)
			Arrays.fill(row, -1);
		return countWaysToMakeChangeUtil(arr, n - 1, T, dp);
	}

	static long countWaysToMakeChangeUtil(int[] arr, int ind, int T, long[][] dp) {

		if (ind == 0) {
			if (T % arr[0] == 0)
				return 1;
			else
				return 0;
		}

		if (dp[ind][T] != -1)
			return dp[ind][T];

		long notTaken = countWaysToMakeChangeUtil(arr, ind - 1, T, dp);

		long taken = 0;
		if (arr[ind] <= T)
			taken = countWaysToMakeChangeUtil(arr, ind, T - arr[ind], dp);

		return dp[ind][T] = notTaken + taken;
	}

}
