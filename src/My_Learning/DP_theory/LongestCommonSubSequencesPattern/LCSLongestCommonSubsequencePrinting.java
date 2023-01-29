package My_Learning.DP_theory.LongestCommonSubSequencesPattern;

import java.util.Arrays;

public class LCSLongestCommonSubsequencePrinting {
	
	public static void main(String args[]) {

		String s1 = "abcdgh";
		String s2 = "abedfhrm";

		
		int[][] dpState = lcsTabulation(s1, s2);
		
		String ans = getLCS(s1, s2, dpState);
		
		System.out.println("The Length of Longest Common Subsequence is :: " + ans.length());
		System.out.println("Content of LCS is :: "+ans);
		
		
	}
	
	private static String getLCS(String s1, String s2, int[][] dpState) {
		String s = "";
		int i = s1.length(); // n
		int j = s2.length(); // m
		
		while(i>0 && j>0) {
			if(s1.charAt(i-1) == s2.charAt(j-1)) {
				s = s1.charAt(i-1) + s;
				i--;
				j--;
			} else {
				if(dpState[i][j-1] > dpState[i-1][j]) {
					j--;
				} else {
					i--;
				}
			}
		}
		
		return s;
	}

	static int[][] lcsTabulation(String s1, String s2) {

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

		return dp;
	}
}
