package My_Learning.DP_theory.LongestCommonSubSequencesPattern;

import java.util.Arrays;

public class LCSLongestCommonSubsequenceLength {

	public static void main(String args[]) {

		String s1 = "abcdgh";
		String s2 = "abedfhrm";

		System.out.println("The Length of Longest Common Subsequence is :: " + lcs(s1, s2));
	}

	// Recursive Solution TC = O(2^n * 2^m)
	static int lcsRecursive(String s1, String s2, int n, int m) {

		if (n == 0 || m == 0)
			return 0;

		if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
			return 1 + lcsRecursive(s1, s2, n - 1, m - 1);
		} else {
			return Math.max(lcsRecursive(s1, s2, n, m - 1), lcsRecursive(s1, s2, n - 1, m));
		}
	}

	// Memoization of recursive relation TC - O(N x M)
	static int lcs(String s1, String s2) {

		int n = s1.length();
		int m = s2.length();

		int dp[][] = new int[n][m];
		for (int rows[] : dp)
			Arrays.fill(rows, -1);
		return lcsUtil(s1, s2, n - 1, m - 1, dp);
	}

	static int lcsUtil(String s1, String s2, int ind1, int ind2, int[][] dp) {

		if (ind1 < 0 || ind2 < 0)
			return 0;

		if (dp[ind1][ind2] != -1)
			return dp[ind1][ind2];

		if (s1.charAt(ind1) == s2.charAt(ind2))
			return dp[ind1][ind2] = 1 + lcsUtil(s1, s2, ind1 - 1, ind2 - 1, dp);

		else
			return dp[ind1][ind2] = 0
					+ Math.max(lcsUtil(s1, s2, ind1, ind2 - 1, dp), lcsUtil(s1, s2, ind1 - 1, ind2, dp));

	}

	// Tabulation - Bottom UP TC = O(N x M)
	static int lcsTabulation(String s1, String s2) {

		int n = s1.length();
		int m = s2.length();

		int dp[][] = new int[n + 1][m + 1];
		for (int rows[] : dp)
			Arrays.fill(rows, -1);

		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i <= m; i++) {
			dp[0][i] = 0;
		}

		for (int ind1 = 1; ind1 <= n; ind1++) {
			for (int ind2 = 1; ind2 <= m; ind2++) {
				if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
					dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
				else
					dp[ind1][ind2] = 0 + Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
			}
		}

		return dp[n][m];
	}

	// Space Optimized space - O(M)
	static int lcsSpaceOptimized(String s1, String s2) {

		int n = s1.length();
		int m = s2.length();

		// Base Case is covered as we have initialized the prev and cur to 0.
		int prev[] = new int[m + 1];
		int cur[] = new int[m + 1];
		for (int ind1 = 1; ind1 <= n; ind1++) {
			for (int ind2 = 1; ind2 <= m; ind2++) {
				if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
					cur[ind2] = 1 + prev[ind2 - 1];
				else
					cur[ind2] = 0 + Math.max(prev[ind2], cur[ind2 - 1]);
			}
			prev = cur;
		}

		return prev[m];
	}
}
