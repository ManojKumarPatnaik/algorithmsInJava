package My_Learning.dynamicProgramming;

public class DeleteOperationTwoStringLeetcode583 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Integer[][] dp;

	// Implementation of LCS question
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

	public int minDistance(String word1, String word2) {
		int lcs = longestCommonSubsequence(word1, word2);

		int deletion = word1.length() - lcs;
		int insertion = word2.length() - lcs;

		return insertion + deletion;
	}

}
