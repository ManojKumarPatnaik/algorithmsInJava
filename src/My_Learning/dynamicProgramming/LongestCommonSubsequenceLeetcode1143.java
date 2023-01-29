package My_Learning.dynamicProgramming;

public class LongestCommonSubsequenceLeetcode1143 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Recursive
	// added recursive method implementation for LCS
	public int longestCommonSubsequenceR(String text1, String text2) {
		return longestCommonSubsequenceR(text1, text2, 0, 0);
	}

	private int longestCommonSubsequenceR(String text1, String text2, int i, int j) {
		if (i == text1.length() || j == text2.length())
			return 0;
		if (text1.charAt(i) == text2.charAt(j))
			return 1 + longestCommonSubsequenceR(text1, text2, i + 1, j + 1);
		else
			return Math.max(longestCommonSubsequenceR(text1, text2, i + 1, j),
					longestCommonSubsequenceR(text1, text2, i, j + 1));
	}

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
