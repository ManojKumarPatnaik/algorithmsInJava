package My_Learning.DP_theory.LongestCommonSubSequencesPattern;

import java.util.Arrays;

public class LCSSLongestCommonSubstringLength {

	public static void main(String args[]) {

		String s1 = "abcdgh";
		String s2 = "abcdfhrm";

		System.out.println("The Length of Longest Common Subsequence is :: " + lcsTabulation(s1, s2));
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
					//dp[ind1][ind2] = 0 + Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
					
					dp[ind1][ind2] = 0;
			}
		}

		int maxi = Integer.MIN_VALUE;
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j<m+1; j++) {
				maxi = Math.max(maxi, dp[i][j]);
			}
		}
		return maxi;
	}
}
