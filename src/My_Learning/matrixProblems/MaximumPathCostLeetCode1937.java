package My_Learning.matrixProblems;

public class MaximumPathCostLeetCode1937 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long maxPoints(int[][] points) {
		long ans = 0;
		int m = points.length, n = points[0].length;
		long[] dp = new long[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[j] += points[i][j];
			}
			for (int j = 1; j < n; j++) {
				dp[j] = Math.max(dp[j], dp[j - 1] - 1);
			}
			for (int j = n - 2; j >= 0; j--) {
				dp[j] = Math.max(dp[j], dp[j + 1] - 1);
			}
		}
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}

}
