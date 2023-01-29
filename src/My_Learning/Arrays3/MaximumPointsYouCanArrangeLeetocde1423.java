package My_Learning.Arrays3;

public class MaximumPointsYouCanArrangeLeetocde1423 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxScore(int[] cardPoints, int k) {
		int[] dp = new int[k + 1];
		// this dp array stores the total points when taking i cards from left.
		// since we could take 0 - k cards from left ,the length of the dp array would
		// be k+1.

		for (int i = cardPoints.length - 1; i >= cardPoints.length - k; i--) {
			dp[0] += cardPoints[i];
		}
		int max_points = dp[0];

		for (int i = 1; i < k + 1; i++) {
			dp[i] = dp[i - 1] + cardPoints[i - 1] - cardPoints[cardPoints.length - k + i - 1];
			max_points = Math.max(max_points, dp[i]);
		}

		return max_points;
	}

}
