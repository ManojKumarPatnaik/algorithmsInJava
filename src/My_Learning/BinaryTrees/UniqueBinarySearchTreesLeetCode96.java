package My_Learning.BinaryTrees;

public class UniqueBinarySearchTreesLeetCode96 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// DP approach
	public int numTrees(int n) {
		if (n == 0)
			return 0;
		// For convenience: when you say you have N numbers, I denote them 0-based as
		// 0..N-1
		// The table: first dimension is SIZE of a tree: 0..N
		// second dimension is index, or 0-based value of the number: 0..N-1. +1 because
		// want to use diagonal to store sumf or [..][I]
		// entry itself is: number of unique trees of size I, and rooted with number (or
		// index) J = 0..I-1
		int[][] dp = new int[n + 1][n + 1];
		dp[0][0] = 1; // only 1 type of empty tree
		for (int i = 1; i < n + 1; i++) {
			for (int j = 0; j < i; j++) {
				// choose [J] of the all [I] numbers as root, then look left and right
				int left_size = j - 1 + 1, right_size = (i - 1) - (j + 1) + 1;
				dp[i][j] = dp[left_size][left_size] * dp[right_size][right_size];
				// dp[i][i] (the diagonal) stores the sum of results for all [..][i]
				dp[i][i] += dp[i][j];
			}
		}
		return dp[n][n];
	}

}
