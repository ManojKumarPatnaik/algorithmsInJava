package My_Learning.graph;

public class MinimumWhiteTilesAfterCoverLeetcode2209 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
		char[] arr = floor.toCharArray();

		int n = arr.length;
		// using dp

		int[][] dp = new int[numCarpets + 1][n + 1];
		// dp[i][j] -> no of whites in arr(0, i) when j carpet is used
		// row -> number of carpets
		// columns -> arr / floor

		for (int i = 0; i <= numCarpets; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 0)
					dp[i][j] = dp[i][j - 1] + (arr[j - 1] - '0');
				else if (j <= carpetLen)// cover all floor
					dp[i][j] = 0;
				else {
					int w = Math.min(dp[i - 1][j - carpetLen], dp[i - 1][j]);
					// minimum no of whites if only j - 1 carpet is used already
					// we want to minimize whites by using or not using jth carpet

					// dp[i][j - 1] -> minimum no of moves if we used i carpets already
					// arr[j - 1] - '0' -> adds white count for j - 1 th char

					int min = Math.min(w, dp[i][j - 1] + (arr[j - 1] - '0'));
					// minimum whites in any case

					dp[i][j] = min;// update
				}
			}
		}

		return dp[numCarpets][n];
	}

}
