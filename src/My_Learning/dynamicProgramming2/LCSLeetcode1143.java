package My_Learning.dynamicProgramming2;

public class LCSLeetcode1143 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Recursive
	public int longestCommonSubsequenceRecursive(String text1, String text2) {
		return longestCommonSubsequenceHelper(text1, text2, 0, 0);
	}

	private int longestCommonSubsequenceHelper(String text1, String text2, int i, int j) {
		if (i == text1.length() || j == text2.length())
			return 0;
		if (text1.charAt(i) == text2.charAt(j))
			return 1 + longestCommonSubsequenceHelper(text1, text2, i + 1, j + 1);
		else
			return Math.max(longestCommonSubsequenceHelper(text1, text2, i + 1, j),
					longestCommonSubsequenceHelper(text1, text2, i, j + 1));
	}

	// DP Solution Memoization
	private Integer[][] dp;

	public int longestCommonSubsequence(String text1, String text2) {
		dp = new Integer[text1.length()][text2.length()];
		return longestCommonSubsequence(text1, text2, 0, 0);
	}

	private int longestCommonSubsequence(String text1, String text2, int i, int j) {
		if (i == text1.length() || j == text2.length())
			return 0;

		if (dp[i][j] != null)
			return dp[i][j];

		if (text1.charAt(i) == text2.charAt(j))
			return dp[i][j] = 1 + longestCommonSubsequence(text1, text2, i + 1, j + 1);
		else
			return dp[i][j] = Math.max(longestCommonSubsequence(text1, text2, i + 1, j),
					longestCommonSubsequence(text1, text2, i, j + 1));
	}

}
